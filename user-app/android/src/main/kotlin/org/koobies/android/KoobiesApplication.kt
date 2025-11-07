package org.koobies.android

import android.app.Application
import compose.user.app.di.initKoin
import org.koin.android.ext.koin.androidContext

/**
 * Application entry point for Android.
 * Initializes Koin dependency injection on app startup.
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