package koobies.shared.app.domain.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class DataStoreManager {
    fun getDataStore(): DataStore<Preferences>
}