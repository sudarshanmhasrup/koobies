package koobies.compose.app.di

import koobies.compose.app.presentation.navigation.ComposeAppNavigationViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val composeAppModule = module {
    viewModelOf(::ComposeAppNavigationViewModel)
}