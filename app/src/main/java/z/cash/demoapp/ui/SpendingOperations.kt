package z.cash.demoapp.ui

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Base64
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uniffi.zcash.ZcashAmount
import uniffi.zcash.ZcashConsensusParameters
import uniffi.zcash.ZcashDustAction
import uniffi.zcash.ZcashDustOutputPolicy
import uniffi.zcash.ZcashFixedFeeRule
import uniffi.zcash.ZcashFixedSingleOutputChangeStrategy
import uniffi.zcash.ZcashLocalTxProver
import uniffi.zcash.ZcashMainFixedGreedyInputSelector
import uniffi.zcash.ZcashMemoBytes
import uniffi.zcash.ZcashOvkPolicy
import uniffi.zcash.ZcashPayment
import uniffi.zcash.ZcashRecipientAddress
import uniffi.zcash.ZcashTestFixedGreedyInputSelector
import uniffi.zcash.ZcashTransactionRequest
import uniffi.zcash.ZcashTxId
import uniffi.zcash.ZcashUnifiedSpendingKey
import uniffi.zcash.ZcashWalletDb
import uniffi.zcash.spendMainFixed
import uniffi.zcash.spendTestFixed
import z.cash.demoapp.utils.WalletDb
import z.cash.demoapp.utils.Constants
import z.cash.demoapp.utils.LightWalletClient
import java.io.File

object SpendingOperations {

    @OptIn(ExperimentalUnsignedTypes::class)
    fun submitTransaction(context: Context) {
        val sharedPref = context.getSharedPreferences(Constants.CACHE_LABEL, Context.MODE_PRIVATE)
        val str = sharedPref.getString(Constants.LAST_TX_ID_LABEL, null)
        val txIdByteArray = Base64.decode(str, Base64.NO_WRAP)

        val parsedTxId = ZcashTxId.fromBytes(txIdByteArray.toUByteArray().toList())

        CoroutineScope(Dispatchers.IO).launch {
            val dbPath = context.getDatabasePath(WalletDb.DATABASE_NAME).absolutePath
            val walletDb = ZcashWalletDb.forPath(dbPath, Constants.PARAMS)
            val tx = walletDb.getTransaction(parsedTxId)

            LightWalletClient.submitTransaction(tx.toBytes().map{ it.toByte() }.toByteArray())

            Log.i("submitTransaction", "Submitted Transaction with Hash ${parsedTxId.toHexString()}")
        }.invokeOnCompletion {
            Handler(Looper.getMainLooper()).post{
                Toast.makeText(context, "Transaction submitted!", Toast.LENGTH_LONG).show()
            }
        }
    }

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
        val minAmount = ZcashAmount(10_000)
        return walletDb.selectSpendableSaplingNotes(Constants.ACCOUNT_ID, minAmount, anchorHeight, listOf()).sumOf { it.value().value() }
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
                        val inputSelector = ZcashTestFixedGreedyInputSelector(fixedChangeStrategy, zdop)
                        spendTestFixed(walletDb, Constants.PARAMS, prover, inputSelector, zusk, request, ZcashOvkPolicy.Sender, Constants.MIN_CONFIRMATIONS)

                    }
                    ZcashConsensusParameters.MAIN_NETWORK -> {
                        val inputSelector = ZcashMainFixedGreedyInputSelector(fixedChangeStrategy, zdop)
                        spendMainFixed(walletDb, Constants.PARAMS, prover, inputSelector, zusk, request, ZcashOvkPolicy.Sender, Constants.MIN_CONFIRMATIONS)
                    }
                }

            Log.i("createTransaction hash", "hash of created transaction: ${txId.toHexString()}")

            saveTransactionId(context, txId)
        }.invokeOnCompletion {
            Handler(Looper.getMainLooper()).post{
                Toast.makeText(context, "Transaction created!", Toast.LENGTH_LONG).show()
            }
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

}