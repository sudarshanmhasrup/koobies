package compose.shared.app.di

import compose.shared.app.data.preferences.DataStoreManager
import compose.shared.app.data.preferences.PreferencesManager
import compose.shared.app.data.preferences.PreferencesManagerImpl
import compose.shared.app.presentation.composeApp.ComposeAppViewModel
import compose.shared.app.presentation.system.SystemBarThemeManager
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    singleOf(::DataStoreManager)
    singleOf(::PreferencesManagerImpl).bind<PreferencesManager>()
    singleOf(::SystemBarThemeManager)
    viewModelOf(::ComposeAppViewModel)
}