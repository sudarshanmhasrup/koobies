package user.onboarding.feature.presentation.pages.language.components

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
import koobies.shared.app.resources.language_page_greetings
import koobies.shared.app.resources.language_page_message
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import user.onboarding.feature.presentation.extensions.greetingsAndMessageModifier

@Composable
internal fun GreetingAndMessage(
    greeting: String,
    message: String,
    modifier: Modifier = Modifier
) {
    val commonModifier = Modifier.fillMaxWidth()

    val primaryFontColor = Theme.colorScheme.primaryFontColor
    val greetingTextStyle =
        Theme.typography.displaySmallBold.copy(color = primaryFontColor, fontWeight = FontWeight.ExtraBold)

    val secondaryFontColor = Theme.colorScheme.secondaryFontColor
    val messageTextStyle = Theme.typography.bodyMediumMedium.copy(color = secondaryFontColor)

    Column(modifier = modifier) {
        BasicText(text = greeting, style = greetingTextStyle, modifier = commonModifier)
        Spacer(modifier = Modifier.height(12.dp))
        BasicText(text = message, style = messageTextStyle, modifier = commonModifier)
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingAndMessagePreview() {
    KoobiesAppTheme(isDarkMode = false) {
        GreetingAndMessage(
            greeting = stringResource(resource = Res.string.language_page_greetings),
            message = stringResource(resource = Res.string.language_page_message),
            modifier = Modifier.greetingsAndMessageModifier()
        )
    }
}