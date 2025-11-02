package user.onboarding.feature.presentation.pages.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import compose.design.system.api.Theme
import koobies.shared.app.presentation.theme.KoobiesAppTheme
import koobies.shared.app.resources.Res
import koobies.shared.app.resources.theme_page_heading
import koobies.shared.app.resources.theme_page_message
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import user.onboarding.feature.presentation.extensions.headingAndMessageModifier

@Composable
internal fun HeadingAndMessage(
    heading: String,
    message: String,
    modifier: Modifier = Modifier
) {
    val commonModifier = Modifier.fillMaxWidth()

    val primaryFontColor = Theme.colorScheme.primaryFontColor
    val headingTextStyle =
        Theme.typography.headlineMediumBold.copy(color = primaryFontColor, fontWeight = FontWeight.ExtraBold)

    val secondaryFontColor = Theme.colorScheme.secondaryFontColor
    val messageTextStyle = Theme.typography.bodyMediumMedium.copy(color = secondaryFontColor)

    Column(modifier = modifier) {
        BasicText(text = heading, style = headingTextStyle, modifier = commonModifier)
        Spacer(modifier = Modifier.height(12.dp))
        BasicText(text = message, style = messageTextStyle, modifier = commonModifier)
    }
}

@Preview(showBackground = true)
@Composable
private fun HeadingAndMessagePreview() {
    KoobiesAppTheme(isDarkMode = false) {
        HeadingAndMessage(
            heading = stringResource(resource = Res.string.theme_page_heading),
            message = stringResource(resource = Res.string.theme_page_message),
            modifier = Modifier.headingAndMessageModifier()
        )
    }
}