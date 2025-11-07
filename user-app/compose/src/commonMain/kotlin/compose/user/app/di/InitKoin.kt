package compose.user.app.di

import compose.shared.app.di.sharedModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import user.onboarding.feature.di.userOnboardingModule

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(composeAppModule, sharedModule, userOnboardingModule)
    }
}