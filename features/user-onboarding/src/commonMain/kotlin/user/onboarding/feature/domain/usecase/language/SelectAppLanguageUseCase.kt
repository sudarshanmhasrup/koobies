package user.onboarding.feature.domain.usecase.language

import user.onboarding.feature.domain.model.language.AppLanguage
import user.onboarding.feature.domain.repository.language.LanguageRepository

internal class SelectAppLanguageUseCase(private val repository: LanguageRepository) {
    suspend operator fun invoke(language: AppLanguage) {
        repository.updateSelectedAppLanguage(language = language)
    }
}