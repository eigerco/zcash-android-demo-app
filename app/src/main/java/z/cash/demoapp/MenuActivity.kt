package z.cash.demoapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import z.cash.demoapp.ui.Components.StandardButton
import z.cash.demoapp.ui.theme.ZcashDemoAppTheme

class MenuActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ZcashDemoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        StandardButton("Spend a note") {
                            startActivity(Intent(this@MenuActivity, SpendingActivity::class.java))
                        }

                        StandardButton("Explore transaction") {
                            startActivity(Intent(this@MenuActivity, TxDetailsActivity::class.java))
                        }

                        StandardButton("Encode or decode addresses") {
                            startActivity(Intent(this@MenuActivity, EncodingActivity::class.java))
                        }

                        StandardButton("See transparent balance of an address") {
                            startActivity(Intent(this@MenuActivity, TransparentBalanceActivity::class.java))
                        }
                    }

                }
            }
        }
    }
}
