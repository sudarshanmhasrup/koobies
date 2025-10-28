package org.koobies.desktop.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.koobies.desktop.presentation.screens.splash.SplashScreenViewModel

internal val appModule = module {
    viewModelOf(::SplashScreenViewModel)
}