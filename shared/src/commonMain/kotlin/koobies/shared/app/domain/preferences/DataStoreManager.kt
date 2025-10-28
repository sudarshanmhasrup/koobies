package koobies.shared.app.domain.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

expect class DataStoreManager {
    fun getDataStore(): DataStore<Preferences>
}