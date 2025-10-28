package koobies.shared.app.di

import koobies.shared.app.domain.preferences.PreferencesManager
import koobies.shared.app.data.preferences.PreferencesManagerImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    singleOf(::PreferencesManagerImpl).bind<PreferencesManager>()
}