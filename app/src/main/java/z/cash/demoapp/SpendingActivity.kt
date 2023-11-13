package z.cash.demoapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import uniffi.zcash.ZcashWalletDb
import z.cash.demoapp.db.WalletDb
import z.cash.demoapp.ui.Components.StandardButton
import z.cash.demoapp.ui.SpendingOperations
import z.cash.demoapp.ui.theme.ZcashDemoAppTheme
import z.cash.demoapp.utils.Constants

class SpendingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dbPath = getDatabasePath(WalletDb.DATABASE_NAME).absolutePath
        val walletDb = ZcashWalletDb.forPath(dbPath, Constants.PARAMS)

        val spendableAmount = try {
            SpendingOperations.spendableAmount(walletDb)
        } catch(_: Throwable) {
            Toast.makeText(this@SpendingActivity, "You need to have some notes in the wallet to spend something!", Toast.LENGTH_LONG).show()
            0
        }

        setContent {
            ZcashDemoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
                Column {
                    var amountToSend by remember { mutableLongStateOf(0L) }
                    Text( text = spendableAmount.toString() )
                    OutlinedTextField(
                        value = amountToSend.toString(),
                        onValueChange = { amountToSend = it.toLong() },
                        label = { Text("Amount of ZATs to send") }
                    )
                    StandardButton("Create Transaction") {
                        if(amountToSend > 0L) {
                            val txRequest = SpendingOperations.makeTransactionRequest(listOf(), Constants.RECIPIENT_ADDRESS, amountToSend)
                            SpendingOperations.createTransaction(this@SpendingActivity, walletDb, txRequest)
                        } else {
                            Toast.makeText(this@SpendingActivity, "You need to input the amount to send", Toast.LENGTH_LONG).show()
                        }
                    }
                    StandardButton("Submit Transaction") {
                        SpendingOperations.submitTransaction(this@SpendingActivity)
                    }
                }
            }
        }
    }
}