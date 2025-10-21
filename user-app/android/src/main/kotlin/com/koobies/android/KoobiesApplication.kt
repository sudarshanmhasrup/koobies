package com.koobies.android

import android.app.Application
import koobies.compose.app.di.initKoin
import org.koin.android.ext.koin.androidContext

class KoobiesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@KoobiesApplication)
        }
    }
}