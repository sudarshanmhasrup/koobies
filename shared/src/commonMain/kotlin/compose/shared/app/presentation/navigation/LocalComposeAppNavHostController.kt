package compose.shared.app.presentation.navigation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

val LocalComposeAppNavHostController = staticCompositionLocalOf<NavHostController> {
    error(message = "No NavHostController provided for the ComposeApp module's navigation host.")
}