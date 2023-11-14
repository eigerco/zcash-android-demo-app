package z.cash.demoapp.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uniffi.zcash.ZcashAccountBirthday
import uniffi.zcash.ZcashAmount
import uniffi.zcash.ZcashBlockHeight
import uniffi.zcash.ZcashFsBlockDb
import uniffi.zcash.ZcashTreeState
import uniffi.zcash.ZcashWalletDb
import z.cash.demoapp.db.WalletDb
import z.cash.demoapp.utils.Constants
import z.cash.demoapp.utils.LightWalletClient

object MainOperations {

    // Resets and initializes the wallet database
    fun resetWalletDb(appCtx: Context, conn: ZcashWalletDb) {
        WalletDb(appCtx).destroy()

        // Forces database creation
        WalletDb(appCtx).writableDatabase!!

        conn.init(Constants.SEED)

        CoroutineScope(Dispatchers.IO).launch {
            val birthday = getUpdatedAccountBirthday()

            conn.createAccount(Constants.SEED, birthday)

            withContext(Dispatchers.Main) {
                Toast.makeText(appCtx, "Successfully reset the wallet db!", Toast.LENGTH_LONG).show()
            }
        }
    }

    // this needs a folder, because it will add a directory for all blocks as raw files
    // and no need of helper
    fun initBlocksDb(appCtx: Context, blocksDir: String) {
        // This gets the `databases` directory
        ZcashFsBlockDb.forPath(blocksDir).init(blocksDir)

        Toast.makeText(appCtx, "Successfully reset the blocks db!", Toast.LENGTH_LONG).show()
    }

    /**
     * In order to create a wallet, we need to indicate a specific point at which
     * the TreeState starts being tracked. The Account birthday indicates the block height
     * at which the Wallet was "born".
     */
    private suspend fun getUpdatedAccountBirthday(): ZcashAccountBirthday {
        // Retrieves the (Sapling) TreeState from the birth of the wallet
        val response = LightWalletClient.getTreeState(Constants.WALLET_BIRTHDAY_HEIGHT)
        val treeState =  response.toByteArray().map { it.toUByte() }.toList()

        // Atomizes all information for the wallet to be used locally (for spending, for example)
        val birthHeight = ZcashBlockHeight(Constants.WALLET_BIRTHDAY_HEIGHT.toUInt())
        val birthState = ZcashTreeState.fromBytes(treeState)
        return ZcashAccountBirthday.fromTreestate(birthState, birthHeight)
    }

    fun getWalletSummary(walletDb: ZcashWalletDb): String {
        val walletSummary = walletDb.getWalletSummary(Constants.MIN_CONFIRMATIONS)!!
        val unifiedAddress = walletDb.getCurrentAddress(Constants.ACCOUNT_ID)
        val transparentAddress = unifiedAddress?.transparent()!!.encode(Constants.PARAMS)
        val saplingAddress = unifiedAddress.sapling()!!.encode(Constants.PARAMS)

        val ws = StringBuilder()

        val chainTipHeight = walletSummary.chainTipHeight().value()
        val fullyScannedHeight = walletSummary.fullyScannedHeight().value()

        val amountDefiningSpendable = ZcashAmount(10_000)
        val anchorHeight = walletDb.getTargetAndAnchorHeights(Constants.MIN_CONFIRMATIONS)!!.anchorHeight
        val walletBirthdayHeight = walletDb.getWalletBirthday()?.value() ?: 0
        val spendableNotes = walletDb.selectSpendableSaplingNotes(Constants.ACCOUNT_ID, amountDefiningSpendable, anchorHeight, listOf())

        ws.appendLine("Transparent address: $transparentAddress")
        Log.i("getWalletSummary", "Transparent address: $transparentAddress")
        ws.appendLine("Sapling address: $saplingAddress")
        Log.i("getWalletSummary", "Sapling address: $saplingAddress")
        ws.appendLine("Chain tip height: $chainTipHeight")
        ws.appendLine("Synced: ${walletSummary.isSynced()}")
        ws.appendLine("Fully synced height: $fullyScannedHeight")
        ws.appendLine("Wallet birthday height: $walletBirthdayHeight")
        ws.appendLine("Account balances:")
        walletSummary.accountBalances().forEach {
            ws.appendLine("Account ID:${it.key}: ${it.value.total().value()}")
        }
        ws.appendLine("Spendable notes:")
        spendableNotes.forEach {
            ws.appendLine(" - Note value in ZATs: ${it.value().value()}")
        }

        return ws.toString()
    }

}