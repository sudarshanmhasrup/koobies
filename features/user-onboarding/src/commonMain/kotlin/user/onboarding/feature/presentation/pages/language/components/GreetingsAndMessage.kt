package user.onboarding.feature.presentation.pages.language.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.design.system.api.ComposeAppTheme
import koobies.shared.app.presentation.theme.KoobiesAppTheme
import koobies.shared.app.resources.Res
import koobies.shared.app.resources.language_page_greetings
import koobies.shared.app.resources.language_page_message
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import user.onboarding.feature.presentation.extensions.greetingsAndMessageModifier

@Composable
internal fun GreetingsAndMessage(
    greetings: String,
    message: String,
    modifier: Modifier = Modifier
) {
    val commonModifier = Modifier.fillMaxWidth()

    val primaryFontColor = ComposeAppTheme.colorScheme.primaryFontColor
    val greetingsTextStyle = ComposeAppTheme.typography.displaySmallBold.copy(color = primaryFontColor)

    val secondaryFontColor = ComposeAppTheme.colorScheme.secondaryFontColor
    val messageTextStyle = ComposeAppTheme.typography.bodyLargeMedium.copy(color = secondaryFontColor)

    Column(modifier = modifier) {
        BasicText(text = greetings, style = greetingsTextStyle, modifier = commonModifier)
        Spacer(modifier = Modifier.height(8.dp))
        BasicText(text = message, style = messageTextStyle, modifier = commonModifier)
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingsAndMessagePreview() {
    KoobiesAppTheme(isDarkMode = false) {
        GreetingsAndMessage(
            greetings = stringResource(resource = Res.string.language_page_greetings),
            message = stringResource(resource = Res.string.language_page_message),
            modifier = Modifier.greetingsAndMessageModifier()
        )
    }
}