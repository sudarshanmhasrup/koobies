package org.koobies.android

import android.app.Application
import koobies.compose.app.di.initKoin
import org.koin.android.ext.koin.androidContext

/**
 * This is the main app class.
 *
 * It runs when the app starts and sets up Koin for dependency injection.
 * Koin helps the app manage dependencies easily.
 */
class KoobiesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize Koin for dependency injection
        initKoin {
            androidContext(this@KoobiesApplication)
        }
    }
}