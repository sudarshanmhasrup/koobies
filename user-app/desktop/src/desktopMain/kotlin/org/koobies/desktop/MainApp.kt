package org.koobies.desktop

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.window.application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import koobies.compose.app.di.initKoin
import org.koobies.desktop.di.appModule
import org.koobies.desktop.presentation.screens.main.MainScreen

fun main() {
    initKoin {
        modules(appModule)
    }

    application {
        // A ViewModelStoreOwner that will be remembered across compositions
        val viewModelStoreOwner = remember {
            object : ViewModelStoreOwner {
                override val viewModelStore: ViewModelStore = ViewModelStore()
            }
        }

        // A LifecycleOwner that will be remembered across compositions
        val lifecycleOwner = remember {
            object : LifecycleOwner {
                private val lifecycleRegistry = LifecycleRegistry(this)

                init {
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
                }

                override val lifecycle: Lifecycle
                    get() = lifecycleRegistry
            }
        }

        CompositionLocalProvider(
            LocalViewModelStoreOwner provides viewModelStoreOwner,
            LocalLifecycleOwner provides lifecycleOwner
        ) {
            MainScreen()
        }
    }
}