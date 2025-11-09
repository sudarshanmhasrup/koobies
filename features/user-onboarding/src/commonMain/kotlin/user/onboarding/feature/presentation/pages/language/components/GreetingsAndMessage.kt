package user.onboarding.feature.presentation.pages.language.components

import androidx.compose.foundation.Image
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
import compose.shared.app.presentation.theme.KoobiesAppTheme
import compose.shared.app.resources.Res
import compose.shared.app.resources.kodee_welcoming_illustration
import compose.shared.app.resources.language_page_greetings
import compose.shared.app.resources.language_page_message
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import user.onboarding.feature.presentation.extensions.greetingsAndMessageModifier

@Composable
internal fun GreetingsAndMessage(
    greetings: String,
    message: String,
    modifier: Modifier = Modifier
) {
    val commonWidthModifier = Modifier.fillMaxWidth()

    val primaryFontColor = Theme.colorScheme.primaryFontColor
    val greetingsTextStyle =
        Theme.typography.displaySmallBold.copy(color = primaryFontColor, fontWeight = FontWeight.ExtraBold)

    val secondaryFontColor = Theme.colorScheme.secondaryFontColor
    val messageTextStyle = Theme.typography.bodyMediumMedium.copy(color = secondaryFontColor)

    Column(modifier = modifier) {
        Image(
            painter = painterResource(resource = Res.drawable.kodee_welcoming_illustration),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(20.dp))
        BasicText(text = greetings, style = greetingsTextStyle, modifier = commonWidthModifier)
        Spacer(modifier = Modifier.height(12.dp))
        BasicText(text = message, style = messageTextStyle, modifier = commonWidthModifier)
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