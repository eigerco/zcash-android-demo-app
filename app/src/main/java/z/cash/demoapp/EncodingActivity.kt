package z.cash.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import uniffi.zcash.ZcashUnifiedAddress
import z.cash.demoapp.ui.theme.ZcashDemoAppTheme
import z.cash.demoapp.utils.Constants
import java.util.Locale
import z.cash.demoapp.ui.Components.LabelTextRow

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
                    var txHashToAnalyze by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = txHashToAnalyze,
                        onValueChange = { txHashToAnalyze = it },
                        label = { Text("Transaction hash") }
                    )
                    LabelTextRow(
                        label = "Transparent address",
                        text = getTransparentAddress(parseUnifiedAddress(txHashToAnalyze))
                    )
                    LabelTextRow(
                        label = "Sapling address",
                        text = getSaplingAddress(parseUnifiedAddress(txHashToAnalyze))
                    )
                    LabelTextRow(
                        label = "Orchard address",
                        text = getOrchardAddress(parseUnifiedAddress(txHashToAnalyze))
                    )
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