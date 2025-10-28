package user.onboarding.feature.data.repository.language

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.data.datasource.language.LocalLanguageDataSource
import user.onboarding.feature.domain.model.language.Language
import user.onboarding.feature.domain.repository.language.LanguageRepository

internal class LanguageRepositoryImpl(private val localLanguageDataSource: LocalLanguageDataSource) : LanguageRepository {
    override fun getLanguages(): Flow<List<Language>> {
        return localLanguageDataSource.getLanguages()
    }

    override fun updateSelectedLanguage(language: Language) {
        localLanguageDataSource.updateSelectedLanguage(language = language)
    }
}