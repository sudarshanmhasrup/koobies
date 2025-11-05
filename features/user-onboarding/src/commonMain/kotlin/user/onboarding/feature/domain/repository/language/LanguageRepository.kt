package user.onboarding.feature.domain.repository.language

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.language.AppLanguage

internal interface LanguageRepository {
    fun getSupportedAppLanguages(): Flow<List<AppLanguage>>
    suspend fun updateSelectedAppLanguage(language: AppLanguage)
    fun getSelectedAppLanguage(): Flow<String>
}