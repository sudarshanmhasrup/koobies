package koobies.shared.app.domain.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DataStoreManager(private val context: Context) {
    actual fun getDataStore(): DataStore<Preferences> {
        return createDataStore(
            producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
        )
    }
}