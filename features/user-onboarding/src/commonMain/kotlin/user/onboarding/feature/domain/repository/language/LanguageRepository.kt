package user.onboarding.feature.domain.repository.language

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.language.Language

internal interface LanguageRepository {
    fun getLanguages(): Flow<List<Language>>
    suspend fun updateSelectedLanguage(locale: String)
}