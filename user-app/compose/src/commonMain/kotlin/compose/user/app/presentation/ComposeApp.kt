package compose.user.app.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import compose.design.system.api.Theme
import compose.shared.app.presentation.composeApp.ComposeAppViewModel
import compose.shared.app.presentation.theme.KoobiesAppTheme
import compose.user.app.presentation.extensions.composeAppModifier
import compose.user.app.presentation.extensions.navigationBarMaskModifier
import compose.user.app.presentation.navigation.ComposeAppNavigation
import io.github.sudarshanmhasrup.localina.api.LocalinaApp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ComposeApp() {
    val composeAppViewModel = koinViewModel<ComposeAppViewModel>()
    val uiState = composeAppViewModel.uiState.collectAsStateWithLifecycle()
    val isDarkMode = uiState.value.isDarkMode

    val composeAppNavHostController = rememberNavController()
    val userOnboardingNavHostController = rememberNavController()

    LocalinaApp {
        KoobiesAppTheme(isDarkMode = isDarkMode) {
            val backgroundColor = Theme.colorScheme.backgroundColor
            Box(modifier = Modifier.composeAppModifier(backgroundColor = backgroundColor)) {
                ComposeAppNavigation(
                    composeAppNavHostController = composeAppNavHostController,
                    userOnboardingNavHostController = userOnboardingNavHostController,
                    modifier = Modifier.fillMaxSize()
                )
                Box(modifier = navigationBarMaskModifier(backgroundColor = backgroundColor))
            }
        }
    }
}