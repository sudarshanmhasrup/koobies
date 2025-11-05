package user.onboarding.feature.domain.usecase.language

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.repository.language.LanguageRepository

internal class GetSelectedAppLanguageUseCase(private val repository: LanguageRepository) {
    operator fun invoke(): Flow<String> {
        return repository.getSelectedAppLanguage()
    }
}