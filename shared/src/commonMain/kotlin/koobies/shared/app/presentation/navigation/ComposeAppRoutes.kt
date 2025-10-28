package koobies.shared.app.presentation.navigation

import kotlinx.serialization.Serializable

sealed class ComposeAppRoutes {
    @Serializable
    object UserOnboarding : ComposeAppRoutes()
}