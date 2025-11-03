package user.onboarding.feature.data.repository.language

import koobies.shared.app.data.preferences.PreferencesManager
import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.data.datasource.local.language.LocalLanguageDataSource
import user.onboarding.feature.domain.model.language.AppLanguage
import user.onboarding.feature.domain.repository.language.LanguageRepository

internal class LanguageRepositoryImpl(
    private val localLanguageDataSource: LocalLanguageDataSource,
    private val userPreferencesManager: PreferencesManager
) : LanguageRepository {
    override fun getSupportedAppLanguages(): Flow<List<AppLanguage>> {
        return localLanguageDataSource.getSupportedAppLanguages()
    }

    override suspend fun updateSelectedAppLanguage(locale: String) {
        localLanguageDataSource.updateSelectedAppLanguage(locale = locale)
        userPreferencesManager.saveSelectedAppLanguage(locale = locale)
    }
}