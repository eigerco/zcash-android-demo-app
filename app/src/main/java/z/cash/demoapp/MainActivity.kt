package z.cash.demoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import uniffi.zcash.ZcashWalletDb
import z.cash.demoapp.utils.WalletDb
import z.cash.demoapp.ui.MainOperations
import z.cash.demoapp.ui.theme.ZcashDemoAppTheme
import z.cash.demoapp.utils.Constants
import z.cash.demoapp.utils.Sync
import z.cash.demoapp.ui.Components.StandardButton
import z.cash.demoapp.ui.Components.TextCard

/**
 * This should have only information about the UI layout and elements
 * MainOperations has the app logic
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // reinitialize the wallet
        val dbPath = getDatabasePath(WalletDb.DATABASE_NAME).absolutePath

        // The Databases are created here, because to create the connection
        // we need the path of the files, and to get those we need the context to be visible.
        // The context in Android is available only under Activities.
        val walletDb = ZcashWalletDb.forPath(dbPath, Constants.PARAMS)
        val blocksDirRoot = getDatabasePath(WalletDb.DATABASE_NAME).parent!!

        var initialSummaryText: String = ""

        try {
            initialSummaryText =
                if(walletDb.getWalletSummary(Constants.MIN_CONFIRMATIONS) != null) {
                    MainOperations.getWalletSummary(walletDb)
                } else {
                    "Wallet not available. A seed is needed to generate the initial wallet information.\n " +
                            "It may be set in \"Constants\""
                }
        } catch(_: Throwable) {
            Toast.makeText(this@MainActivity, "Database not initialized", Toast.LENGTH_LONG).show()
        }

        setContent {
            ZcashDemoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        var displaySummaryText by remember { mutableStateOf(initialSummaryText) }
                        TextCard("Wallet summary", displaySummaryText)
                        StandardButton("Reset database") {
                            MainOperations.resetWalletDb(applicationContext, walletDb)
                            MainOperations.initBlocksDb(applicationContext, blocksDirRoot)
                        }
                        StandardButton("Download blocks") {
                            Sync.downloadBlocks(dbPath, blocksDirRoot)
                            Toast.makeText(this@MainActivity, "Blocks downloaded!", Toast.LENGTH_LONG).show()
                        }
                        StandardButton("Update from db") {
                            displaySummaryText = MainOperations.getWalletSummary(walletDb)
                            Toast.makeText(this@MainActivity, "Updated!", Toast.LENGTH_LONG).show()
                        }
                        StandardButton("Go to menu") {
                            startActivity(Intent(this@MainActivity, MenuActivity::class.java))
                        }
                    }
                }
            }
        }
    }
}