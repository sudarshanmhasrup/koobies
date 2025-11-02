package user.onboarding.feature.presentation.navigation

import kotlinx.serialization.Serializable

internal sealed class UserOnboardingRoutes {
    @Serializable
    object LanguagePage : UserOnboardingRoutes()
    @Serializable
    object ThemePage : UserOnboardingRoutes()
}