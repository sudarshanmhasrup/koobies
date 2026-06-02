package org.koobies.app

import androidx.compose.ui.window.application
import io.github.sudarshanmhasrup.splashify.SplashifyApp
import org.koobies.app.splash.SplashScreen

fun main() {
    application {
        SplashifyApp(splashScreen = ::SplashScreen) {

        }
    }
}