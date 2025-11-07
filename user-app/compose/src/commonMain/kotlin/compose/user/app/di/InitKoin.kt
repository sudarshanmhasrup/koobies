package compose.user.app.di

import compose.shared.app.di.sharedModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import user.onboarding.feature.di.userOnboardingModule

/**
 * Starts Koin for the app and loads shared + platform modules.
 *
 * @param config Optional block to set up custom Koin settings (e.g., Android context).
 *
 * Example:
 * ```
 * initKoin {
 *     androidContext(context)
 * }
 * ```
 */
fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(composeAppModule, sharedModule, userOnboardingModule)
    }
}