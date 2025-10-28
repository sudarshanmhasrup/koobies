package user.onboarding.feature.domain.usecase.language

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.language.Language
import user.onboarding.feature.domain.repository.language.LanguageRepository

internal class GetLanguagesUseCase(private val languageRepository: LanguageRepository) {
    operator fun invoke(): Flow<List<Language>> {
        return languageRepository.getLanguages()
    }
}