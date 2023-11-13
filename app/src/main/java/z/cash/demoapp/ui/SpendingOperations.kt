package z.cash.demoapp.ui

import android.content.Context
import android.util.Base64
import android.util.Log
import cash.z.wallet.sdk.internal.rpc.CompactFormats
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uniffi.zcash.ZcashAccountId
import uniffi.zcash.ZcashAmount
import uniffi.zcash.ZcashConsensusParameters
import uniffi.zcash.ZcashDustAction
import uniffi.zcash.ZcashDustOutputPolicy
import uniffi.zcash.ZcashFixedFeeRule
import uniffi.zcash.ZcashFixedSingleOutputChangeStrategy
import uniffi.zcash.ZcashLocalTxProver
import uniffi.zcash.ZcashMainGreedyInputSelector
import uniffi.zcash.ZcashMemoBytes
import uniffi.zcash.ZcashOvkPolicy
import uniffi.zcash.ZcashPayment
import uniffi.zcash.ZcashRecipientAddress
import uniffi.zcash.ZcashTestGreedyInputSelector
import uniffi.zcash.ZcashTransactionRequest
import uniffi.zcash.ZcashTxId
import uniffi.zcash.ZcashUnifiedSpendingKey
import uniffi.zcash.ZcashWalletDb
import uniffi.zcash.spendMain
import uniffi.zcash.spendTest
import z.cash.demoapp.db.FirstClassByteArray
import z.cash.demoapp.db.WalletDb
import z.cash.demoapp.db.toHex
import z.cash.demoapp.utils.Constants
import z.cash.demoapp.utils.LightWalletClient
import java.io.File

object SpendingOperations {

    @OptIn(ExperimentalUnsignedTypes::class)
    fun submitTransaction(context: Context) {
        val sharedPref = context.getSharedPreferences(Constants.CACHE_LABEL, Context.MODE_PRIVATE)
        val str = sharedPref.getString(Constants.LAST_TX_ID_LABEL, null)
        val txIdByteArray = Base64.decode(str, Base64.NO_WRAP)

        val byteArray = FirstClassByteArray(txIdByteArray)

        val parsedTxId = ZcashTxId.fromBytes(txIdByteArray.toUByteArray().toList())
        Log.i("submitTransaction", "Submitted Transaction with Hash ${parsedTxId.toHexString()}")

        CoroutineScope(Dispatchers.IO).launch {
            val encodedTransaction = WalletDb(context).findEncodedTransactionByTxId(byteArray)
            LightWalletClient.submitTransaction(encodedTransaction!!.raw.byteArray)
        }
    }

    // A transaction request
    fun makeTransactionRequest(
        memoBytes: List<UByte>,
        addressTo: String,
        amount: Long,
    ): ZcashTransactionRequest {

        val recAddress = ZcashRecipientAddress.decode(Constants.PARAMS, addressTo)

        val memo = ZcashMemoBytes(memoBytes)

        // if the address is shielded, include the memo, otherwise
        // set null, as the transparent or deshielding transaction
        // cannot contain a memo field
        val memoField = if(addressTo.contains("sapling")) { memo } else { null }

        val payment = ZcashPayment(
            recipientAddress = recAddress,
            amount = ZcashAmount(amount),
            memo = memoField,
            label = "label",
            message = "message",
            otherParams = listOf(),
        )

        return ZcashTransactionRequest(listOf(payment))
    }

    private fun makeProver(context: Context): ZcashLocalTxProver {
        val outputParams = File(context.filesDir.absolutePath,"/sapling-output.params").absolutePath
        val spendParams = File(context.filesDir.absolutePath,"/sapling-spend.params").absolutePath
        return ZcashLocalTxProver(spendParams, outputParams)
    }

    fun spendableAmount(walletDb: ZcashWalletDb): Long {
        val anchorHeight = walletDb.getTargetAndAnchorHeights(Constants.MIN_CONFIRMATIONS)!!.anchorHeight
        return walletDb.selectSpendableSaplingNotes(ZcashAccountId(0u), ZcashAmount(10_000), anchorHeight, listOf()).sumOf { it.value().value() }
    }

    fun createTransaction(
        context: Context,
        walletDb: ZcashWalletDb,
        request: ZcashTransactionRequest) {

        val zusk = ZcashUnifiedSpendingKey.fromSeed(Constants.PARAMS, Constants.SEED, Constants.ACCOUNT_ID)

        val zdop = ZcashDustOutputPolicy(ZcashDustAction.REJECT, null)

        // Here the fee rule is the pre-ZIP-317 standard fixed fee.
        val fixedRule = ZcashFixedFeeRule.standard()
        val fixedChangeStrategy = ZcashFixedSingleOutputChangeStrategy(fixedRule)

        CoroutineScope(Dispatchers.IO).launch {
            // This is an expensive operation and better to
            // leave it out of the main thread
            val prover = makeProver(context)

            val txId =
                when(Constants.PARAMS) {
                    ZcashConsensusParameters.TEST_NETWORK -> {
                        val inputSelector = ZcashTestGreedyInputSelector(fixedChangeStrategy, zdop)
                        spendTest(walletDb, Constants.PARAMS, prover, inputSelector, zusk, request, ZcashOvkPolicy.Sender, Constants.MIN_CONFIRMATIONS)

                    }
                    ZcashConsensusParameters.MAIN_NETWORK -> {
                        val inputSelector = ZcashMainGreedyInputSelector(fixedChangeStrategy, zdop)
                        spendMain(walletDb, Constants.PARAMS, prover, inputSelector, zusk, request, ZcashOvkPolicy.Sender, Constants.MIN_CONFIRMATIONS)
                    }
                }

            Log.i("createTransaction hash", "hash of created transaction: 0x${txId.toHexString()}")

            saveTransactionId(context, txId)
        }
    }

    // Here we want to do everything step by step, so the transaction id
    // is saved in the internal memory of the application as a string,
    // and then recovered to submit the transaction
    private fun saveTransactionId(context: Context, txId: ZcashTxId) {
        val sharedPref = context.getSharedPreferences(Constants.CACHE_LABEL, Context.MODE_PRIVATE)

        val txIdAsString = Base64.encodeToString(txId.toBytes().map { it.toByte() }.toByteArray(), Base64.NO_WRAP)

        with (sharedPref.edit()) {
            putString(Constants.LAST_TX_ID_LABEL, txIdAsString)
            apply()
        }
    }

    // auxiliary functions for debugging
    private fun logTxHash(tx: CompactFormats.CompactTx) {
        Log.i("fetchTransactionsForBlock", "TX HASH: " + tx.toHex() )
    }
}

fun CompactFormats.CompactTx.toHex() {
    val txHash = this.hash.toByteArray()
    txHash.reverse()
    txHash.toHex()
}