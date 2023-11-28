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
import uniffi.zcash.ZcashUnifiedAddress
import uniffi.zcash.ZcashWalletDb
import z.cash.demoapp.utils.WalletDb
import z.cash.demoapp.ui.theme.ZcashDemoAppTheme
import z.cash.demoapp.utils.Constants
import java.util.Locale
import z.cash.demoapp.ui.Components.LabelTextRow
import z.cash.demoapp.ui.Components.StandardButton

class EncodingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ZcashDemoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /**
                     * the ideal approach would be to save state as ZcashUnifiedAddress and not as a string,
                     * but that might end up shadowing our efforts to show off how to use the library.
                     * See for example:
                     *  - https://developer.android.com/jetpack/compose/state-saving
                     *  - https://developer.android.com/kotlin/parcelize
                     */
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        var uaAddress by remember { mutableStateOf("") }
                        var tAddress by remember { mutableStateOf("") }
                        var sAddress by remember { mutableStateOf("") }
                        var oAddress by remember { mutableStateOf("") }
                        OutlinedTextField(
                            value = uaAddress,
                            onValueChange = { uaAddress = it },
                            label = { Text("Transaction hash") }
                        )
                        /**
                         * hack for quick testing: getting the UA from the account
                         * we generated
                         */
                        StandardButton("Paste test UA from db") {
                            val dbPath = getDatabasePath(WalletDb.DATABASE_NAME).absolutePath
                            val walletDb = ZcashWalletDb.forPath(dbPath, Constants.PARAMS)
                            uaAddress = walletDb.getCurrentAddress(Constants.ACCOUNT_ID)?.encode(Constants.PARAMS) ?: ""
                        }
                        StandardButton("Parse address") {
                            val ua = parseUnifiedAddress(uaAddress)
                            tAddress = getTransparentAddress(ua)
                            sAddress = getSaplingAddress(ua)
                            oAddress = getOrchardAddress(ua)
                        }
                        LabelTextRow(
                            label = "Transparent address",
                            text = tAddress
                        )
                        LabelTextRow(
                            label = "Sapling address",
                            text = sAddress
                        )
//                        LabelTextRow(
//                            label = "Orchard address",
//                            text = oAddress
//                        )
                    }
                }
            }
        }
    }

    private fun parseUnifiedAddress(address: String): ZcashUnifiedAddress {
        return ZcashUnifiedAddress.decode(address = address, params = Constants.PARAMS)
    }

    private fun getTransparentAddress(ua: ZcashUnifiedAddress): String {
        return ua.transparent()?.encode(Constants.PARAMS) ?: "no tAddress"
    }

    private fun getSaplingAddress(ua: ZcashUnifiedAddress): String {
        return ua.sapling()?.encode(Constants.PARAMS) ?: "no sAddress"
    }

    private fun getOrchardAddress(ua: ZcashUnifiedAddress): String {
        return ua.orchard()?.toRawAddressBytes()?.toHex() ?: "no oAddress"
    }

}

fun List<UByte>.toHex(): String {
    val sb = StringBuilder(size * 2)
    for (b in this) {
        sb.append(String.format(Locale.ROOT, "%02x", b))
    }
    return sb.toString()
}
