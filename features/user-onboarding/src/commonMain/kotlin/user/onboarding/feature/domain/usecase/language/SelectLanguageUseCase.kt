package user.onboarding.feature.domain.usecase.language

import user.onboarding.feature.domain.model.language.Language
import user.onboarding.feature.domain.repository.language.LanguageRepository

internal class SelectLanguageUseCase(private val languageRepository: LanguageRepository) {
    suspend operator fun invoke(language: Language) {
        languageRepository.updateSelectedLanguage(language = language)
    }
}