package koobies.shared.app.data.preferences

import kotlinx.coroutines.flow.Flow

internal interface PreferencesManager {
    fun saveSelectedAppLanguage(locale: String)
    fun getSelectedAppLanguage(): Flow<String>
}