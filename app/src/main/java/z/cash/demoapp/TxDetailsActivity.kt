package z.cash.demoapp

import android.content.Context
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import uniffi.zcash.ZcashTxId
import uniffi.zcash.ZcashWalletDb
import z.cash.demoapp.utils.WalletDb
import z.cash.demoapp.ui.Components.StandardButton
import z.cash.demoapp.ui.Components.TextCard
import z.cash.demoapp.ui.theme.ZcashDemoAppTheme
import z.cash.demoapp.ui.TxDetailsOperations
import z.cash.demoapp.utils.Constants

@OptIn(ExperimentalUnsignedTypes::class)
class TxDetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dbPath = getDatabasePath(WalletDb.DATABASE_NAME).absolutePath

        // This database is created here, because to create the connection
        // we need the path of the files, and to get those we need the context to be visible.
        // The context in Android is available only under Activities.
        val walletDb = ZcashWalletDb.forPath(dbPath, Constants.PARAMS)

        setContent {
            ZcashDemoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    // contains the transaction details returned by the library
                    var text by remember { mutableStateOf("") }
                    // contains the transaction hash pasted or entered in the field
                    var txHash by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = txHash,
                        onValueChange = {
                            txHash = it
                            try {
                                if (txHash.length == 64) {
                                    text = TxDetailsOperations.getFormattedTextForTxDetails(walletDb, txHash)
                                }
                            } catch (e: Throwable) {
                                e.message?.let { it1 -> Log.e("fatal", it1) }
                                Toast.makeText(this@TxDetailsActivity, "The transaction hash is invalid!", Toast.LENGTH_SHORT).show()
                            }
                        },
                        label = { Text("Transaction hash") }
                    )
                    StandardButton("Paste test transaction") {
                      txHash = "74e2c1e54bfa96b0485552d32dc6ac6871568be72a218aa8a6e07c62123fc27e"
                    }
                    StandardButton("Get last transaction") {
                        val sharedPref = applicationContext.getSharedPreferences(Constants.CACHE_LABEL, Context.MODE_PRIVATE)
                        val str = sharedPref.getString(Constants.LAST_TX_ID_LABEL, null)
                        val txIdByteArray = Base64.decode(str, Base64.NO_WRAP)
                        val parsedTxId = ZcashTxId.fromBytes(txIdByteArray.toUByteArray().toList())
                        val tx = walletDb.getTransaction(parsedTxId)
                        text = TxDetailsOperations.getFormattedTextForTxDetails(walletDb, tx, tx.expiryHeight())
                    }
                    TextCard("Transaction details", text)
                }
            }
        }
    }

}

