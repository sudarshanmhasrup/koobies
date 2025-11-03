package koobies.shared.app.data.preferences

import kotlinx.coroutines.flow.Flow

interface PreferencesManager {
    suspend fun saveSelectedAppLanguage(locale: String)
    fun getSelectedAppLanguage(): Flow<String>
}