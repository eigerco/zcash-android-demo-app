package z.cash.demoapp.ui

import com.google.protobuf.ByteString
import kotlinx.coroutines.runBlocking
import uniffi.zcash.ZcashBlockHeight
import uniffi.zcash.ZcashBranchId
import uniffi.zcash.ZcashTransaction
import uniffi.zcash.ZcashWalletDb
import uniffi.zcash.decryptTransaction
import z.cash.demoapp.toHex
import z.cash.demoapp.utils.Constants
import z.cash.demoapp.utils.LightWalletClient
import java.util.Locale

object TxDetailsOperations {
    /**
     * To extract information from a shielded transaction we need the viewing keys in the database,
     * otherwise we would need only the txHash information.
     */
    fun getFormattedTextForTxDetails(walletDb: ZcashWalletDb, txHash: String): String {
        // There are much better ways to handle coroutines jobs,
        // but in this case we just need the transaction to be processed further.
        val (ztx, zht) = runBlocking {
            return@runBlocking getTransactionAndHeightFromHash(txHash)
        }

        // There are several pieces of information to be gathered
        // for a transaction, mostly for shielded transactions on Sapling and Orchard
        val sb = StringBuilder()

        val transparentBundle = ztx.transparentBundle()
        if(transparentBundle?.vout()?.size != null) {
            sb.appendLine("This transaction is transparent or deshielding")
            sb.appendLine("There are ${transparentBundle.vin().size} transparent inputs.")
            sb.appendLine("There are ${transparentBundle.vout().size} transparent outputs:")
            transparentBundle.vout().forEachIndexed { idx, it ->
                sb.appendLine( "VOUT #$idx")

                val recAddress = it.recipientAddress()!!.encode(Constants.PARAMS)
                val amountSpent = it.value().value()
                val pubKey = it.scriptPubkey().toString()

                sb.appendLine("transparent vout - recipient address: $recAddress")
                sb.appendLine("transparent vout - amount spent: $amountSpent")
                sb.appendLine("transparent vout - script pub key: $pubKey")
            }

        }

        val saplingBundle = ztx.saplingBundle()
        if(saplingBundle?.shieldedOutputs() != null) {
            sb.appendLine(" - This transaction is shielding or shielded")

            sb.appendLine(" - There are ${saplingBundle.shieldedSpends().size} shielded spends (inputs).")
            sb.appendLine(" - There are ${saplingBundle.shieldedOutputs().size} shielded outputs:")

            // The transaction is protected for everyone but for the sender of these transactions.
            // If the database contains an Account with the proper viewing keys,
            // the code below will be able to show some information.
            // Otherwise, everything below will be masked.
            val ufvks = walletDb.getUnifiedFullViewingKeys()
            val decryptedOutput = decryptTransaction(Constants.PARAMS, zht, ztx, ufvks)
            sb.appendLine("Below, the decrypted output:")
            decryptedOutput.forEach {
                with(it) {
                    sb.appendLine("------------------")
                    sb.appendLine(" - index: ${index()} ")
                    sb.appendLine(" - note value: ${note().value().inner()}")
                    sb.appendLine(" - account ID: ${account().id}")
                    sb.appendLine(" - memo: ${memo().data().toHex()}")
                    sb.appendLine(" - transfer type: ${transferType()}")
                }
            }
        }
        return sb.toString()
    }

    private suspend fun getTransactionAndHeightFromHash(txHash: String): Pair<ZcashTransaction, ZcashBlockHeight> {
        val bytesFromHex = txHash.fromHex()
        bytesFromHex.reverse()
        val rawTransaction = LightWalletClient.getTransaction(ByteString.copyFrom(bytesFromHex))
        // Most UniFFI functions in the library use unsigned integers,
        // so this is a common situation
        val txData = rawTransaction.data.toByteArray().map { it.toUByte() }
        // The height is needed for decrypting shielded outputs
        val zht = ZcashBlockHeight(rawTransaction.height.toUInt())
        // SAPLING because the library doesn't support Orchard yet,
        // but in the future this might change
        return Pair(ZcashTransaction.fromBytes(txData, ZcashBranchId.SAPLING), zht)
    }

}
internal fun String.fromHex(): ByteArray {
    val len = length
    val data = ByteArray(len / 2)
    var i = 0
    while (i < len) {
        data[i / 2] =
            ((Character.digit(this[i], 16) shl 4) + Character.digit(this[i + 1], 16)).toByte()
        i += 2
    }
    return data
}