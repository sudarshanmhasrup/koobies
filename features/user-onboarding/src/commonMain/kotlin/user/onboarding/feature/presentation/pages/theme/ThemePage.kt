package user.onboarding.feature.presentation.pages.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_MEDIUM_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND
import compose.design.system.components.RoundButton
import compose.shared.app.presentation.theme.KoobiesAppTheme
import compose.shared.app.resources.Res
import compose.shared.app.resources.continue_button_label
import compose.shared.app.resources.dark_theme_type_message
import compose.shared.app.resources.dark_theme_type_name
import compose.shared.app.resources.done_button_label
import compose.shared.app.resources.light_theme_type_message
import compose.shared.app.resources.light_theme_type_name
import compose.shared.app.resources.system_theme_type_message
import compose.shared.app.resources.system_theme_type_name
import compose.shared.app.resources.theme_page_heading
import compose.shared.app.resources.theme_page_message
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import user.onboarding.feature.domain.model.theme.ThemeType
import user.onboarding.feature.presentation.extensions.continueButtonBackgroundModifier
import user.onboarding.feature.presentation.extensions.headingAndMessageModifier
import user.onboarding.feature.presentation.model.theme.AppThemeUi
import user.onboarding.feature.presentation.navigation.LocalUserOnboardingNavHostController
import user.onboarding.feature.presentation.navigation.UserOnboardingRoute
import user.onboarding.feature.presentation.pages.theme.components.HeadingAndMessage
import user.onboarding.feature.presentation.pages.theme.components.ThemeCard

@Composable
internal fun ThemePage(modifier: Modifier = Modifier) {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val isLandscapeMode = windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND) &&
            !windowSizeClass.isHeightAtLeastBreakpoint(HEIGHT_DP_MEDIUM_LOWER_BOUND)

    if (isLandscapeMode) {
        Row(modifier = modifier.padding(start = 20.dp)) {
            val layoutModifier = Modifier
                .weight(1f)
                .align(alignment = Alignment.CenterVertically)
            ThemePageLayout(
                isLandscapeMode = isLandscapeMode,
                modifier = layoutModifier,
                modifier2 = Modifier.weight(1f)
            )
        }
    } else {
        Column(modifier = modifier) {
            ThemePageLayout(modifier = Modifier.fillMaxWidth(), modifier2 = Modifier.fillMaxWidth().fillMaxHeight())
        }
    }
}

@Composable
private fun ThemePageLayout(
    isLandscapeMode: Boolean = false,
    modifier: Modifier = Modifier,
    modifier2: Modifier = Modifier
) {
    val composeAppNavHostController = LocalUserOnboardingNavHostController.current

    Box(modifier = modifier) {
        HeadingAndMessage(
            heading = stringResource(resource = Res.string.theme_page_heading),
            message = stringResource(resource = Res.string.theme_page_message),
            modifier = Modifier.headingAndMessageModifier(isLandscapeMode = isLandscapeMode)
        )
    }
    Box(modifier = modifier2) {
        LanguageList(modifier = modifier2)
        // Continue button background
        Box(modifier = continueButtonBackgroundModifier()) {
            RoundButton(
                label = stringResource(resource = Res.string.done_button_label),
                onClick = {
                    composeAppNavHostController.navigate(route = UserOnboardingRoute.LandingPage)
                }
            )
        }
    }
}

@Composable
private fun localizedThemes(themes: List<AppThemeUi>): List<AppThemeUi> {
    return themes.map {
        when (it.appTheme.themeType) {
            ThemeType.System -> it.copy(
                name = stringResource(resource = Res.string.system_theme_type_name),
                message = stringResource(Res.string.system_theme_type_message),
            )

            ThemeType.Light -> it.copy(
                name = stringResource(resource = Res.string.light_theme_type_name),
                message = stringResource(Res.string.light_theme_type_message)
            )

            ThemeType.Dark -> it.copy(
                name = stringResource(resource = Res.string.dark_theme_type_name),
                message = stringResource(Res.string.dark_theme_type_message)
            )
        }
    }
}

@Composable
private fun LanguageList(modifier: Modifier = Modifier) {
    val themePageViewModel = koinViewModel<ThemePageViewModel>()
    val uiState = themePageViewModel.uiState.collectAsStateWithLifecycle()
    val supportedAppThemes = uiState.value.supportedAppThemes

    val localizedThemes = localizedThemes(themes = supportedAppThemes)
    themePageViewModel.onUpdateSupportedAppThemes(supportedAppThemes = localizedThemes)

    LazyColumn(modifier = modifier.padding(vertical = 20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = supportedAppThemes) { theme ->
            ThemeCard(
                theme = theme,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    themePageViewModel.onUpdateSelectedAppTheme(theme = theme.appTheme)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ThemePagePreview() {
    KoobiesAppTheme(isDarkMode = false) {
        ThemePage(modifier = Modifier.fillMaxSize())
    }
}