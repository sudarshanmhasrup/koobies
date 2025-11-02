package user.onboarding.feature.presentation.navigation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

internal val LocalUserOnboardingNavHostController = staticCompositionLocalOf<NavHostController> {
    error(message = "No NavHostController provided for the UserOnboarding module's navigation host.")
}