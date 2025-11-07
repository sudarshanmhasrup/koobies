package compose.shared.app.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal expect class DataStoreManager() {
    fun getDataStore(): DataStore<Preferences>
}