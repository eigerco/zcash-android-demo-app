package z.cash.demoapp.utils

import android.util.Log
import cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import uniffi.zcash.ZcashAmount
import uniffi.zcash.ZcashBlockHeight
import uniffi.zcash.ZcashBranchId
import uniffi.zcash.ZcashFsBlockDb
import uniffi.zcash.ZcashOutPoint
import uniffi.zcash.ZcashTransaction
import uniffi.zcash.ZcashTransparentAddress
import uniffi.zcash.ZcashTxOut
import uniffi.zcash.ZcashWalletDb
import uniffi.zcash.ZcashWalletTransparentOutput
import uniffi.zcash.decryptAndStoreTransaction
import uniffi.zcash.scanCachedBlocks
import java.io.File

/**
 * The only purpose of this object is to contain a way
 * to download all the blocks necessary
 * for a single spending event to work.
 */
object Sync {
    private val client = LightWalletClient

    fun downloadBlocks(walletDbPath: String, blocksDirRoot: String) {

        val walletDb = ZcashWalletDb.forPath(walletDbPath, Constants.PARAMS)
        val fsBlockDb = ZcashFsBlockDb.forPath(blocksDirRoot)

        val latestHeight = runBlocking {
            val latestBlockHeight = client.getLatestBlockHeight()
            return@runBlocking latestBlockHeight.height
        }

        val rangeStart = latestHeight - Constants.MAX_BLOCKS_TO_SCAN

        val repo = BlocksRepo.new(File(blocksDirRoot))

        CoroutineScope(Dispatchers.IO).launch {
//            updateSaplingRoots(walletDb)

            val fetchingRange = rangeStart .. latestHeight

            val latestBlocks = client.downloadBlockRange(fetchingRange)

            repo.write(fsBlockDb, latestBlocks.map { it })

            latestBlocks.collect { block ->
                block.vtxList.forEach {
                    fetchTransactionsForBlock(walletDb, it)
                }
            }

            fetchUtxosForAddress(walletDb)

        }.invokeOnCompletion {
            scanCachedBlocks(Constants.PARAMS,
                blocksDirRoot,
                walletDbPath,
                ZcashBlockHeight(rangeStart.toUInt()),
                Constants.MAX_BLOCKS_TO_SCAN.toUInt(),
            )
        }
    }

    private suspend fun fetchTransactionsForBlock(walletDb: ZcashWalletDb, tx: CompactTx) {
        val response = client.getTransaction(tx.hash)
//        val txHash = tx.hash.toByteArray()
//        txHash.reverse()
//        Log.i("ZSYNC", "TX HASH: " + txHash.toHex() )
        val txData = response.data.map{ it.toUByte() }
        val ztx = ZcashTransaction.fromBytes(txData, ZcashBranchId.SAPLING)
        decryptAndStoreTransaction(Constants.PARAMS, walletDb, ztx)
    }

    private suspend fun fetchUtxosForAddress(walletDb: ZcashWalletDb) {
        val ua = walletDb.getCurrentAddress(Constants.ACCOUNT_ID)

        val transparentAddress =
            if (ua != null) {
                ua.transparent()!!
            } else {
                throw Error("Transparent address doesn't exist!")
            }

        val responseFlow = client.getUtxos(transparentAddress.encode(Constants.PARAMS))

        responseFlow.collect {
            val txIdBytes = it.txid.map { x -> x.toUByte() }.toList()
//            val scriptBytes = it.script.map { x -> x.toUByte() }.toList()
            val index = it.index.toUInt()
            val height = it.height.toUInt()

            putUtxo(
                walletDb,
                transparentAddress,
                txIdBytes,
                index,
                it.valueZat,
                height
            )
        }

    }

    private fun putUtxo(
        walletDb: ZcashWalletDb,
        addressIn: ZcashTransparentAddress,
        transactionId: List<UByte>,
        index: UInt,
        value: Long,
        heightIn: UInt,
    ): Long {
        val outPoint = ZcashOutPoint(transactionId, index)
        val height = ZcashBlockHeight(heightIn)
        val txOut =  ZcashTxOut(ZcashAmount(value), addressIn.script())

        val output = ZcashWalletTransparentOutput.fromParts(outPoint , txOut, height)

        return walletDb.putReceivedTransparentUtxo(output)
    }
}

