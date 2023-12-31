package z.cash.demoapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import uniffi.zcash.ZcashWalletDb
import z.cash.demoapp.utils.WalletDb
import z.cash.demoapp.ui.Components
import z.cash.demoapp.ui.Components.StandardButton
import z.cash.demoapp.ui.SpendingOperations
import z.cash.demoapp.ui.theme.ZcashDemoAppTheme
import z.cash.demoapp.utils.Constants

class SpendingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dbPath = getDatabasePath(WalletDb.DATABASE_NAME).absolutePath
        val walletDb = ZcashWalletDb.forPath(dbPath, Constants.PARAMS)

        val spendableAmount = getSpendableAmountOrToast(walletDb)

        setContent {
            ZcashDemoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
                Column {
                    var amountToSend by remember { mutableLongStateOf(0L) }
                    Components.LabelTextRow(
                        label = "Spendable amount",
                        text = spendableAmount.toString()
                    )
                    OutlinedTextField (
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = amountToSend.toString(),
                        onValueChange = {
                            amountToSend = try {
                                it.toLong()
                            } catch(_: Throwable) {
                                0
                            }

                        },
                        label = { Text("Amount of ZATs to send") }
                    )
                    StandardButton("Create Transaction") {
                        createTransaction(this@SpendingActivity, walletDb, amountToSend)
                    }
                    StandardButton("Submit Transaction") {
                        SpendingOperations.submitTransaction(this@SpendingActivity)
                    }
                }
            }
        }
    }

    /**
     * Trying to reduce the amount of exceptions that may occur in the UI
     * Keeping these functions here as the toast text is better visible.
     */
    private fun getSpendableAmountOrToast(walletDb: ZcashWalletDb): Long {
        return try {
            SpendingOperations.spendableAmount(walletDb)
        } catch(_: Throwable) {
            Toast.makeText(this@SpendingActivity, "You need to have some notes in the wallet to spend something!", Toast.LENGTH_LONG).show()
            0L
        }
    }

    private fun createTransaction(ctx: Context, walletDb: ZcashWalletDb, amountToSend: Long) {
        if(amountToSend > 0L) {
            val txRequest = SpendingOperations.makeTransactionRequest(listOf(), Constants.RECIPIENT_ADDRESS, amountToSend)
            SpendingOperations.createTransaction(ctx, walletDb, txRequest)
            Toast.makeText(ctx, "Transaction created!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(ctx, "You need to input the amount to send", Toast.LENGTH_LONG).show()
        }
    }
}