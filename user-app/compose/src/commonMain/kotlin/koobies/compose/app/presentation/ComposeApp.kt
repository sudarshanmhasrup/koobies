package koobies.compose.app.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import compose.design.system.api.Theme
import io.github.sudarshanmhasrup.localina.api.LocalinaApp
import koobies.compose.app.presentation.extensions.composeAppModifier
import koobies.compose.app.presentation.extensions.navigationBarMaskModifier
import koobies.compose.app.presentation.navigation.ComposeAppNavigation
import koobies.shared.app.presentation.composeApp.ComposeAppViewModel
import koobies.shared.app.presentation.theme.KoobiesAppTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ComposeApp() {
    val composeAppViewModel = koinViewModel<ComposeAppViewModel>()
    val uiState = composeAppViewModel.uiState.collectAsStateWithLifecycle()
    val isDarkMode = uiState.value.isDarkMode

    val composeAppNavHostController = rememberNavController()

    LocalinaApp {
        KoobiesAppTheme(isDarkMode = isDarkMode) {
            val backgroundColor = Theme.colorScheme.backgroundColor
            Box(modifier = Modifier.composeAppModifier(backgroundColor = backgroundColor)) {
                ComposeAppNavigation(composeAppNavHostController = composeAppNavHostController, modifier = Modifier.fillMaxSize())
                Box(modifier = navigationBarMaskModifier(backgroundColor = backgroundColor))
            }
        }
    }
}