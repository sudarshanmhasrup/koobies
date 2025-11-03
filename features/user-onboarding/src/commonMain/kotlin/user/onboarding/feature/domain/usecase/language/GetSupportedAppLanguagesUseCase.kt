package user.onboarding.feature.domain.usecase.language

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.language.AppLanguage
import user.onboarding.feature.domain.repository.language.LanguageRepository

internal class GetSupportedAppLanguagesUseCase(private val repository: LanguageRepository) {
    operator fun invoke(): Flow<List<AppLanguage>> {
        return repository.getSupportedAppLanguages()
    }
}