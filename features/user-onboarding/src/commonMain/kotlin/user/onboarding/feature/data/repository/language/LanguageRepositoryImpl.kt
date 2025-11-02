package user.onboarding.feature.data.repository.language

import io.github.sudarshanmhasrup.localina.api.LocaleUpdater
import koobies.shared.app.domain.preferences.PreferencesManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import user.onboarding.feature.data.datasource.local.language.LocalLanguageDataSource
import user.onboarding.feature.domain.model.language.Language
import user.onboarding.feature.domain.repository.language.LanguageRepository

internal class LanguageRepositoryImpl(
    private val localLanguageDataSource: LocalLanguageDataSource,
    private val userPreferencesManager: PreferencesManager
) : LanguageRepository {
    init {
        CoroutineScope(Dispatchers.IO).launch {
            val selectedLanguage = userPreferencesManager.getSelectedLanguage().first()
            updateSelectedLanguage(locale = selectedLanguage)
        }
    }

    override fun getLanguages(): Flow<List<Language>> {
        return localLanguageDataSource.getLanguages()
    }

    override suspend fun updateSelectedLanguage(locale: String) {
        localLanguageDataSource.updateSelectedLanguage(locale = locale)
        LocaleUpdater.updateLocale(locale = locale)
    }
}