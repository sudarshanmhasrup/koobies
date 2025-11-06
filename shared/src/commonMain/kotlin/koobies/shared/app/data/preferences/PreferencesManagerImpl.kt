package koobies.shared.app.data.preferences

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PreferencesManagerImpl : PreferencesManager, KoinComponent {
    private val dataStoreManager: DataStoreManager by inject()
    private val dataStore = dataStoreManager.getDataStore()

    override suspend fun saveSelectedAppLanguage(locale: String) {
        dataStore.edit { preferences ->
            preferences[SELECTED_LANGUAGE_KEY] = locale
        }
    }

    override fun getSelectedAppLanguage(): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[SELECTED_LANGUAGE_KEY] ?: "en"
        }
    }

    override suspend fun saveSelectedAppTheme(theme: String) {
        dataStore.edit { preferences ->
            preferences[SELECTED_THEME_KEY] = theme
        }
    }

    override fun getSelectedAppTheme(): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[SELECTED_THEME_KEY] ?: "System"
        }
    }

    companion object {
        private val SELECTED_LANGUAGE_KEY = stringPreferencesKey(name = "selected_app_language")
        private val SELECTED_THEME_KEY = stringPreferencesKey(name = "selected_app_theme")
    }
}