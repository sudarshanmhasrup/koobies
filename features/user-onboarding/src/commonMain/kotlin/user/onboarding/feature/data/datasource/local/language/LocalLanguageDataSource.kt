package user.onboarding.feature.data.datasource.local.language

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.language.Language

internal interface LocalLanguageDataSource {
    fun getLanguages(): Flow<List<Language>>
    suspend fun updateSelectedLanguage(language: Language)
}