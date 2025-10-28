package koobies.shared.app.domain.preferences

import kotlinx.coroutines.flow.Flow

interface PreferencesManager {
    suspend fun saveSelectedLanguage(locale: String)
    suspend fun getSelectedLanguage(): Flow<String>
}