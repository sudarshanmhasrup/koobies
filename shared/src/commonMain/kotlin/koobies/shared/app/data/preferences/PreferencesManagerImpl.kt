package koobies.shared.app.data.preferences

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreferencesManagerImpl : PreferencesManager {
    private val dataStoreManager = DataStoreManager()
    private val dataStore = dataStoreManager.getDataStore()

    override suspend fun saveSelectedAppLanguage(locale: String) {
        dataStore.edit { preferences ->
            preferences[SELECTED_LANGUAGE_KEY] = locale
        }
    }

    override fun getSelectedAppLanguage(): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[SELECTED_LANGUAGE_KEY] ?: ""
        }
    }

    companion object {
        private val SELECTED_LANGUAGE_KEY = stringPreferencesKey("selected_app_language")
    }
}