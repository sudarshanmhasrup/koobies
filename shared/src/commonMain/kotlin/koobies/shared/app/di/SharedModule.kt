package koobies.shared.app.di

import koobies.shared.app.data.preferences.DataStoreManager
import koobies.shared.app.data.preferences.PreferencesManager
import koobies.shared.app.data.preferences.PreferencesManagerImpl
import koobies.shared.app.presentation.composeApp.ComposeAppViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    singleOf(::DataStoreManager)
    singleOf(::PreferencesManagerImpl).bind<PreferencesManager>()
    viewModelOf(::ComposeAppViewModel)
}