package koobies.shared.app.presentation.navigation

import kotlinx.serialization.Serializable

/**
 * Central navigation route definitions for the entire Compose Multiplatform app.
 * Each route represents a screen or feature that can be navigated to across platforms.
 */
sealed class ComposeAppRoutes {
    @Serializable
    object UserOnboarding : ComposeAppRoutes()
}