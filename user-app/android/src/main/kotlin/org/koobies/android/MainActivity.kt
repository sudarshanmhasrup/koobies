package org.koobies.android

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import koobies.compose.app.AndroidApp
import koobies.shared.app.presentation.splash.SplashScreenManager
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/**
 * App's main entry point.
 *
 * It shows a splash screen while loading, makes the app full screen, shows the main UI, sets up Koin, and waits until
 * the UI is ready.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            AndroidApp()
        }

        // Load Koin module for this Activity
        loadKoinModules(
            module {
                single<Activity> { this@MainActivity }
            }
        )

        // Wait until SplashScreenManager says UI is ready
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (SplashScreenManager.isUiReady()) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        false
                    }
                }
            }
        )
    }
}