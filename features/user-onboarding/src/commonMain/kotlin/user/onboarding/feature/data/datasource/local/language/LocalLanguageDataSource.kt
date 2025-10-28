package user.onboarding.feature.data.datasource.local.language

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.language.Language

internal interface LocalLanguageDataSource {
    fun getLanguages(): Flow<List<Language>>
    fun updateSelectedLanguage(language: Language)
}