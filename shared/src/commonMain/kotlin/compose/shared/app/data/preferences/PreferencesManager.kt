package compose.shared.app.data.preferences

import kotlinx.coroutines.flow.Flow

interface PreferencesManager {
    suspend fun saveSelectedAppLanguage(locale: String)
    fun getSelectedAppLanguage(): Flow<String>

    suspend fun saveSelectedAppTheme(theme: String)
    fun getSelectedAppTheme(): Flow<String>
}