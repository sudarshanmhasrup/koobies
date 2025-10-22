package org.koobies.desktop

import androidx.compose.ui.window.application
import koobies.compose.app.di.initKoin

/**
 * Entry point of the desktop application.
 * This function initializes the dependency injection framework and launches the Compose desktop UI.
 *
 * The application uses Koin for dependency injection, which must be initialized before the UI.
 * The Compose desktop application is created using the [application] {} DSL builder.
 */
fun main() {
    // Initialize the Koin dependency injection framework
    initKoin()

    // Launch the Compose desktop application
    application {

    }
}