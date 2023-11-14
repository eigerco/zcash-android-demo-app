package z.cash.demoapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import z.cash.demoapp.ui.Components.LabelTextRow
import z.cash.demoapp.ui.Components.StandardButton
import z.cash.demoapp.ui.TransparentBalanceOperations
import z.cash.demoapp.ui.theme.ZcashDemoAppTheme

/**
 * Below there is a construction of how to discern type of address
 * given as a string.
 * Since we don't interact with the database here,
 * there is no need to initialize it.
 */
class TransparentBalanceActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ZcashDemoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /**
                     * This is a bit more involved as UI - it validates the address
                     * before showing the button for calculating the total balance,
                     * which involves downloading all UTXOs present,
                     * so it might be an expensive operation.
                     * Keep in mind that the number of UTXOs downloaded is limited in `Constants` by `MAX_UTXOS`
                     */
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        var address by remember { mutableStateOf("") }
                        var balance by remember { mutableLongStateOf(0) }
                        var isValid by remember { mutableStateOf(false) }
                        OutlinedTextField(
                            value = address,
                            onValueChange = {
                                Log.i("testbal", "value changed!")
                                isValid = TransparentBalanceOperations.isValidTransparentAddress(it)
                                address = it
                            },
                            label = { Text("Transparent address") },
                            isError = !isValid
                        )

                        if (!isValid) {
                            Text(text = "The address given is invalid", color = Color.Red)
                        } else {
                            LabelTextRow(label = "Balance", text = balance.toString())
                            StandardButton("Get address balance") {
                                balance =
                                    TransparentBalanceOperations.getBalanceFromTransparentAddress(
                                        address
                                    )
                            }
                        }

                        StandardButton("Paste test address") {
                            address = "tmRecgPfjvzjaNAzFLHmyFzkTJNc6c1PJf8"
                        }
                    }
                }
            }
        }
    }
}

