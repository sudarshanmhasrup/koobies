package user.onboarding.feature.presentation.navigation

import kotlinx.serialization.Serializable

internal sealed class UserOnboardingRoute {
    @Serializable
    object LanguagePage : UserOnboardingRoute()

    @Serializable
    object ThemePage : UserOnboardingRoute()

    @Serializable
    object LandingPage : UserOnboardingRoute()
}