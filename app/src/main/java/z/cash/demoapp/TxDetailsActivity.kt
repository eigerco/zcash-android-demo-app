package z.cash.demoapp

import android.os.Bundle
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
import uniffi.zcash.ZcashWalletDb
import z.cash.demoapp.db.WalletDb
import z.cash.demoapp.ui.Components.TextCard
import z.cash.demoapp.ui.theme.ZcashDemoAppTheme
import z.cash.demoapp.ui.TxDetailsOperations.getFormattedTextForTxDetails
import z.cash.demoapp.utils.Constants

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
                    var text by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = text,
                        onValueChange = {
                            text = getFormattedTextForTxDetails(walletDb, it)
                        },
                        label = { Text("Transaction hash") }
                    )
                    TextCard("Transaction details", text)
                }
            }
        }
    }

}

