package compose.design.system.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.design.system.api.Theme

@Composable
fun RoundButton(
    label: String,
    onClick: () -> Unit
) {
    val buttonColor = ButtonDefaults.buttonColors(containerColor = Theme.colorScheme.primaryColor)
    Button(colors = buttonColor, contentPadding = PaddingValues(all = 0.dp), onClick = onClick) {
        Text(
            text = label,
            color = Color.White,
            style = Theme.typography.labelLargeBold,
            modifier = Modifier.padding(all = 20.dp)
        )
    }
}