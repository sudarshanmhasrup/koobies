package user.onboarding.feature.presentation.pages.landing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import compose.shared.app.presentation.theme.KoobiesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun LandingPage(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {

    }
}

@Composable
private fun HeadingAndMessage(heading: String, message: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {

    }
}

@Preview(showBackground = true)
@Composable
private fun LandingPagePreview() {
    KoobiesAppTheme(isDarkMode = false) {
        LandingPage(modifier = Modifier.fillMaxSize())
    }
}