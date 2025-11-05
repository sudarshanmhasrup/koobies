package user.onboarding.feature.data.repository.language

import koobies.shared.app.data.preferences.PreferencesManager
import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.data.datasource.local.language.LocalLanguageDataSource
import user.onboarding.feature.domain.model.language.AppLanguage
import user.onboarding.feature.domain.repository.language.LanguageRepository

internal class LanguageRepositoryImpl(
    private val dataSource: LocalLanguageDataSource,
    private val preferencesManager: PreferencesManager
) : LanguageRepository {
    override fun getSupportedAppLanguages(): Flow<List<AppLanguage>> {
        return dataSource.getSupportedAppLanguages()
    }

    override suspend fun updateSelectedAppLanguage(language: AppLanguage) {
        preferencesManager.saveSelectedAppLanguage(locale = language.locale)
    }

    override fun getSelectedAppLanguage(): Flow<String> {
        return preferencesManager.getSelectedAppLanguage()
    }
}