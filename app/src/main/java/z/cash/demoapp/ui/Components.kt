package z.cash.demoapp.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Components {

    @Composable
    fun TextCard(title: String, text: String) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            modifier = Modifier
                .size(width = 360.dp, height = 440.dp)
                .verticalScroll(rememberScrollState())
                .padding(top = 10.dp)) {
            Text(
                text = title,
                modifier = Modifier.padding(12.dp),
                textAlign = TextAlign.Center,
            )
            Text(
                text = text,
                modifier = Modifier.padding(12.dp),
                textAlign = TextAlign.Left
            )
        }
    }

    @Composable
    fun StandardButton(label: String = "", onClick: () -> Unit = {}) {
        FilledTonalButton(
            onClick = { onClick() }, modifier = Modifier
                .padding(2.dp) // padding inside
                .size(width = 300.dp, height = 70.dp)
                .padding(10.dp) // margin
        ) {
            Text(text = label, fontSize = 20.sp)
        }
    }

    @Composable
    fun LabelTextRow(label: String, text: String) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
            Text(
                text = label,
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                    ),
            )
            Text(
                text = text,
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                    ),
            )
        }
    }
}