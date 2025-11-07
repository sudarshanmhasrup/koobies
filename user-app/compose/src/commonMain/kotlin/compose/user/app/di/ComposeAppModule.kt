package compose.user.app.di

import compose.user.app.presentation.navigation.ComposeAppNavigationViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val composeAppModule = module {
    viewModelOf(::ComposeAppNavigationViewModel)
}