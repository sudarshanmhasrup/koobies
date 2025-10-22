package com.koobies.android

import android.app.Application
import koobies.compose.app.di.initKoin
import org.koin.android.ext.koin.androidContext


/**
 * Main Android application class for Koobies app that handles app initialization
 */
class KoobiesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize the Koin dependency injection framework with Android context
        initKoin {
            androidContext(this@KoobiesApplication)
        }
    }
}