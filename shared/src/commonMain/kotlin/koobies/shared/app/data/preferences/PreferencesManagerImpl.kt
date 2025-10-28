package koobies.shared.app.data.preferences

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import koobies.shared.app.domain.preferences.DataStoreManager
import koobies.shared.app.domain.preferences.PreferencesManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreferencesManagerImpl : PreferencesManager {
    private val dataStoreManager = DataStoreManager()
    private val dataStore = dataStoreManager.getDataStore()

    override suspend fun saveSelectedLanguage(locale: String) {
        dataStore.edit { dataStore ->
            dataStore[SELECTED_LANGUAGE_KEY] = locale
        }
    }

    override suspend fun getSelectedLanguage(): Flow<String> {
        return dataStore.data.map { dataStore ->
            dataStore[SELECTED_LANGUAGE_KEY] ?: ""
        }
    }

    companion object {
        private val SELECTED_LANGUAGE_KEY = stringPreferencesKey("selected_language")
    }
}