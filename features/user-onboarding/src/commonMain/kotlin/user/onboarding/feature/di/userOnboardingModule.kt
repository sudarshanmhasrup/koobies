package user.onboarding.feature.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import user.onboarding.feature.data.datasource.local.language.LocalLanguageDataSource
import user.onboarding.feature.data.datasource.local.language.LocalLanguageDataSourceImpl
import user.onboarding.feature.data.repository.language.LanguageRepositoryImpl
import user.onboarding.feature.domain.repository.language.LanguageRepository
import user.onboarding.feature.domain.usecase.language.GetLanguagesUseCase
import user.onboarding.feature.domain.usecase.language.SelectLanguageUseCase
import user.onboarding.feature.presentation.pages.language.LanguagePageViewModel

val userOnboardingModule = module {
    singleOf(::LocalLanguageDataSourceImpl).bind<LocalLanguageDataSource>()
    singleOf(::LanguageRepositoryImpl).bind<LanguageRepository>()
    singleOf(::GetLanguagesUseCase)
    singleOf(::SelectLanguageUseCase)
    viewModelOf(::LanguagePageViewModel)
}