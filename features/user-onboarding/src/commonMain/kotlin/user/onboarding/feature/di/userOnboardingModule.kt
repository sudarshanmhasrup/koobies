package user.onboarding.feature.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import user.onboarding.feature.data.datasource.local.language.LocalLanguageDataSource
import user.onboarding.feature.data.datasource.local.language.LocalLanguageDataSourceImpl
import user.onboarding.feature.data.datasource.local.theme.LocalThemeDataSource
import user.onboarding.feature.data.datasource.local.theme.LocalThemeDataSourceImpl
import user.onboarding.feature.data.repository.language.LanguageRepositoryImpl
import user.onboarding.feature.data.repository.theme.ThemeRepositoryImpl
import user.onboarding.feature.domain.repository.language.LanguageRepository
import user.onboarding.feature.domain.repository.theme.ThemeRepository
import user.onboarding.feature.domain.usecase.language.GetSupportedAppLanguagesUseCase
import user.onboarding.feature.domain.usecase.language.SelectAppLanguageUseCase
import user.onboarding.feature.domain.usecase.theme.GetSupportedAppThemesUseCase
import user.onboarding.feature.presentation.pages.language.LanguagePageViewModel
import user.onboarding.feature.presentation.pages.theme.ThemePageViewModel

val userOnboardingModule = module {
    singleOf(::LocalLanguageDataSourceImpl).bind<LocalLanguageDataSource>()
    singleOf(::LanguageRepositoryImpl).bind<LanguageRepository>()
    singleOf(::GetSupportedAppLanguagesUseCase)
    singleOf(::SelectAppLanguageUseCase)
    viewModelOf(::LanguagePageViewModel)

    singleOf(::LocalThemeDataSourceImpl).bind<LocalThemeDataSource>()
    singleOf(::ThemeRepositoryImpl).bind<ThemeRepository>()
    singleOf(::GetSupportedAppThemesUseCase)
    viewModelOf(::ThemePageViewModel)
}