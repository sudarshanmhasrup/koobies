package koobies.shared.app.presentation.navigation

import kotlinx.serialization.Serializable

sealed class ComposeAppRoute {
    @Serializable
    data object UserOnboarding : ComposeAppRoute()
}