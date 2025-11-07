package user.onboarding.feature.presentation.pages.language.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.design.system.api.Theme
import compose.shared.app.presentation.theme.KoobiesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import user.onboarding.feature.domain.model.language.AppLanguage
import user.onboarding.feature.presentation.model.language.AppLanguageUi

@Composable
internal fun LanguageCard(
    language: AppLanguageUi,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val commonWidthModifier = Modifier.fillMaxWidth()
    val backgroundModifier = modifier
        .background(color = Theme.colorScheme.backgroundColor)
        .clickable(onClick = onClick)
        .padding(vertical = 12.dp, horizontal = 8.dp)

    val radioButtonColors = RadioButtonDefaults.colors(
        selectedColor = Theme.colorScheme.primaryColor,
        unselectedColor = Theme.colorScheme.tertiaryColor
    )

    val primaryFontColor = Theme.colorScheme.primaryFontColor
    val nameTextStyle = Theme.typography.titleMediumSemiBold.copy(color = primaryFontColor)

    val secondaryFontColor = Theme.colorScheme.secondaryFontColor
    val messageTextStyle = Theme.typography.bodyMediumMedium.copy(color = secondaryFontColor)

    Row(verticalAlignment = Alignment.CenterVertically, modifier = backgroundModifier) {
        RadioButton(selected = language.isSelected, colors = radioButtonColors, onClick = onClick)
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            BasicText(text = language.appLanguage.name, style = nameTextStyle, modifier = commonWidthModifier)
            Spacer(modifier = Modifier.height(6.dp))
            BasicText(text = language.appLanguage.message, style = messageTextStyle, modifier = commonWidthModifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LanguageCardPreview() {
    KoobiesAppTheme(isDarkMode = false) {
        val language = AppLanguage(name = "English", message = "Use this app in English", locale = "en")
        LanguageCard(
            language = AppLanguageUi(appLanguage = language, isSelected = true),
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        )
    }
}