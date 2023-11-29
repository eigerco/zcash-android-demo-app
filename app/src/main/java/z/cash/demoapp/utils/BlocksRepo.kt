package z.cash.demoapp.utils

import android.util.Log
import cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock
import cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import uniffi.zcash.ZcashBlockHash
import uniffi.zcash.ZcashBlockHeight
import uniffi.zcash.ZcashBlockMeta
import uniffi.zcash.ZcashFsBlockDb
import java.io.File
import java.util.Locale

/**
 * This class is, as a whole, dedicated to writing blocks
 * to the folder repository and `fsBlocksDb` database.
 */
class BlocksRepo(
    private val blocksDirectory: File
) {

    suspend fun write(fsBlocksDb: ZcashFsBlockDb, blocks: Flow<CompactBlock>): List<CompactBlock> {
        val processingBlocks = mutableListOf<CompactBlock>()
        val metaDataBuffer = mutableListOf<CompactBlock>()
        blocks.collect { block ->
            val tmpFile = block.createTemporaryFile(blocksDirectory)
            // write compact block bytes
            tmpFile.writeBytesSuspend(block.toByteArray())
            // buffer metadata
            metaDataBuffer.add(block)

            val isFinalizeSuccessful = tmpFile.finalizeFile()
            check(isFinalizeSuccessful) {
                "Failed to finalize file: ${tmpFile.absolutePath}"
            }

            if (metaDataBuffer.isBufferFull()) {
                processingBlocks.addAll(metaDataBuffer)
                writeAndClearBuffer(fsBlocksDb, metaDataBuffer)
            }
        }

        if (metaDataBuffer.isNotEmpty()) {
            processingBlocks.addAll(metaDataBuffer)
            writeAndClearBuffer(fsBlocksDb, metaDataBuffer)
        }

        return processingBlocks
    }

    /*
     * Write block metadata to storage when the buffer is full or when we reached the current range end.
     */
    private fun writeAndClearBuffer(fsBlocksDb: ZcashFsBlockDb, metaDataBuffer: MutableList<CompactBlock>) {
        runCatching {
            fsBlocksDb.writeBlockMetadata (metaDataBuffer.map{ cb ->
                val height = ZcashBlockHeight(cb.height.toUInt())
                val hash = ZcashBlockHash.fromSlice(cb.hash.map{ it.toUByte() })
                val (saplingOutputsCount, orchardOutputsCount) = getOutputsCounts(cb.vtxList)
                ZcashBlockMeta(height, hash, cb.time.toUInt(), saplingOutputsCount, orchardOutputsCount)
            })
        }.onFailure {
//            Twig.error { "Failed to write block metadata with $it" }
            // We should inform the caller about the operation failure as well
            Log.e("FATAL", "Failed to write block metadata with $it")
        }
        metaDataBuffer.clear()
    }

    /**
     * Although Orchard support is still not there,
     * this counts both actions and outputs for  retrocompatibility issues
     */
    private fun getOutputsCounts(vtxList: List<CompactTx>): Pair<UInt, UInt> {
        var outputsCount: UInt = 0u
        var actionsCount: UInt = 0u

        vtxList.forEach { compactTx ->
            outputsCount += compactTx.outputsCount.toUInt()
            actionsCount += compactTx.actionsCount.toUInt()
        }

        return Pair(outputsCount, actionsCount)
    }

    companion object {
        /**
         * Blocks repo are handled on this side for the blocks root, since we need access
         * to the folders and file system for better management of the blocks.
         */
        fun new(blockCacheRoot: File): BlocksRepo {
            // create and check cache directories
            val blocksDirectory = File(blockCacheRoot, BLOCKS_DOWNLOAD_DIRECTORY).also {
                it.mkdirs()
            }
            if (!blocksDirectory.exists()) {
                error("${blocksDirectory.path} directory does not exist and could not be created.")
            }

            return BlocksRepo(blocksDirectory)
        }
    }
}



/**
 * The name of the directory for downloading blocks
 */
internal const val BLOCKS_DOWNLOAD_DIRECTORY = "blocks"

/**
 * The suffix for temporary files
 */
internal const val TEMPORARY_FILENAME_SUFFIX = ".tmp"

/**
 * The suffix for block file name
 */
internal const val BLOCK_FILENAME_SUFFIX = "-compactblock"

/**
 * The size of block meta data buffer
 */
internal const val BLOCKS_METADATA_BUFFER_SIZE = 10

internal fun List<CompactBlock>.isBufferFull(): Boolean {
    return size % BLOCKS_METADATA_BUFFER_SIZE == 0
}

internal fun ByteArray.toHexReversed(): String {
    val sb = StringBuilder(size * 2)
    var i = size - 1
    while (i >= 0) {
        sb.append(String.format(Locale.ROOT, "%02x", this[i--]))
    }
    return sb.toString()
}
internal fun CompactBlock.createFilename(): String {
    val hashHex = hash.toByteArray().toHexReversed()
    return "$height-$hashHex${BLOCK_FILENAME_SUFFIX}"
}

internal suspend fun CompactBlock.createTemporaryFile(blocksDirectory: File): File {
    val tempFileName = "${createFilename()}${TEMPORARY_FILENAME_SUFFIX}"

    val tmpFile = File(blocksDirectory, tempFileName)

    if (tmpFile.existsSuspend()) {
        tmpFile.deleteSuspend()
    }

    tmpFile.createNewFileSuspend()

    return tmpFile
}


internal suspend fun File.finalizeFile(): Boolean {
    // rename the file
    val newFile = File(absolutePath.dropLast(TEMPORARY_FILENAME_SUFFIX.length))
    return renameToSuspend(newFile)
}


suspend fun File.createNewFileSuspend() = withContext(Dispatchers.IO) { createNewFile() }

suspend fun File.deleteSuspend() = withContext(Dispatchers.IO) { delete() }

suspend fun File.existsSuspend() = withContext(Dispatchers.IO) { exists() }
suspend fun File.renameToSuspend(dest: File) = withContext(Dispatchers.IO) { renameTo(dest) }

suspend fun File.writeBytesSuspend(byteArray: ByteArray) = withContext(Dispatchers.IO) { writeBytes(byteArray) }