package user.onboarding.feature.data.repository

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.data.datasource.LocalLanguageDataSource
import user.onboarding.feature.domain.model.language.Language
import user.onboarding.feature.domain.repository.language.LanguageRepository

internal class LanguageRepositoryImpl(private val dataSource: LocalLanguageDataSource) : LanguageRepository {
    override fun getLanguages(): Flow<List<Language>> {
        return dataSource.getLanguages()
    }

    override fun updateSelectedLanguage(language: Language) {
        dataSource.updateSelectedLanguage(language = language)
    }
}