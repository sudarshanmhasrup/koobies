package user.onboarding.feature.presentation.pages.language

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_MEDIUM_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND
import compose.design.system.components.RoundButton
import koobies.shared.app.presentation.theme.KoobiesAppTheme
import koobies.shared.app.resources.Res
import koobies.shared.app.resources.continue_button_label
import koobies.shared.app.resources.language_page_greetings
import koobies.shared.app.resources.language_page_message
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import user.onboarding.feature.presentation.extensions.continueButtonBackgroundModifier
import user.onboarding.feature.presentation.extensions.greetingsAndMessageModifier
import user.onboarding.feature.presentation.navigation.LocalUserOnboardingNavHostController
import user.onboarding.feature.presentation.navigation.UserOnboardingRoute
import user.onboarding.feature.presentation.pages.language.components.GreetingsAndMessage
import user.onboarding.feature.presentation.pages.language.components.LanguageCard

@Composable
fun LanguagePage(modifier: Modifier = Modifier) {
    val languagePageViewModel = koinViewModel<LanguagePageViewModel>()

    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val isLandscapeMode = windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND) &&
            !windowSizeClass.isHeightAtLeastBreakpoint(HEIGHT_DP_MEDIUM_LOWER_BOUND)

    if (isLandscapeMode) {
        Row(modifier = modifier.padding(start = 60.dp)) {
            val layoutModifier = Modifier
                .weight(1f)
                .align(alignment = Alignment.CenterVertically)
            LanguagePageLayout(
                isLandscapeMode = isLandscapeMode,
                modifier = layoutModifier,
                modifier2 = Modifier.weight(1f),
            )
        }
    } else {
        Column(modifier = modifier) {
            LanguagePageLayout(modifier = Modifier.fillMaxWidth(), modifier2 = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun LanguagePageLayout(
    isLandscapeMode: Boolean = false,
    modifier: Modifier = Modifier,
    modifier2: Modifier = Modifier
) {
    val userOnboardingNavHostController = LocalUserOnboardingNavHostController.current
    val languagePageViewModel = koinViewModel<LanguagePageViewModel>()

    Box(modifier = modifier) {
        GreetingsAndMessage(
            greetings = stringResource(resource = Res.string.language_page_greetings),
            message = stringResource(resource = Res.string.language_page_message),
            modifier = Modifier.greetingsAndMessageModifier(isLandscapeMode = isLandscapeMode)
        )
    }
    Box(modifier = modifier2) {
        LanguageList(modifier = modifier2)
        // Continue button background
        Box(modifier = continueButtonBackgroundModifier()) {
            RoundButton(
                label = stringResource(resource = Res.string.continue_button_label),
                onClick = {
                    languagePageViewModel.onLanguageSelected()
                    userOnboardingNavHostController.navigate(route = UserOnboardingRoute.ThemePage)
                }
            )
        }
    }
}

@Composable
private fun LanguageList(modifier: Modifier = Modifier) {
    val languagePageViewModel = koinViewModel<LanguagePageViewModel>()
    val uiState = languagePageViewModel.uiState.collectAsState()
    val supportedAppLanguages = uiState.value.supportedAppLanguages

    LazyColumn(modifier = modifier.padding(top = 20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = supportedAppLanguages) { language ->
            LanguageCard(
                language = language,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    languagePageViewModel.onLanguageSelected(language = language.appLanguage)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LanguagePagePreview() {
    KoobiesAppTheme(isDarkMode = false) {
        LanguagePage(modifier = Modifier.fillMaxSize())
    }
}