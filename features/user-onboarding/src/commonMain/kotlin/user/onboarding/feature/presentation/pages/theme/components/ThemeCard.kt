package user.onboarding.feature.presentation.pages.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.design.system.api.Theme
import compose.shared.app.presentation.theme.KoobiesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.model.theme.ThemeType
import user.onboarding.feature.presentation.model.theme.AppThemeUi

@Composable
internal fun ThemeCard(
    theme: AppThemeUi,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val commonModifier = Modifier.fillMaxWidth()

    val radioButtonColors = RadioButtonDefaults.colors(
        selectedColor = Theme.colorScheme.primaryColor,
        unselectedColor = Theme.colorScheme.tertiaryColor
    )

    val primaryFontColor = Theme.colorScheme.primaryFontColor
    val nameTextStyle = Theme.typography.titleMediumSemiBold.copy(color = primaryFontColor)

    val secondaryFontColor = Theme.colorScheme.secondaryFontColor
    val messageTextStyle = Theme.typography.bodyMediumMedium.copy(color = secondaryFontColor)

    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        RadioButton(selected = theme.isSelected, colors = radioButtonColors, onClick = onClick)
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            BasicText(text = theme.name, style = nameTextStyle, modifier = commonModifier)
            Spacer(modifier = Modifier.height(6.dp))
            BasicText(text = theme.message, style = messageTextStyle, modifier = commonModifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LanguageCardPreview() {
    KoobiesAppTheme(isDarkMode = false) {
        val appTheme = AppTheme(themeType = ThemeType.Light)
        val theme = AppThemeUi(name = "System Default", appTheme = appTheme, isSelected = true)
        ThemeCard(theme = theme, modifier = Modifier.fillMaxWidth(), onClick = {})
    }
}