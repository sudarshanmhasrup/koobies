package koobies.shared.app.domain.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import java.io.File

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DataStoreManager {
    actual fun getDataStore(): DataStore<Preferences> {
        return createDataStore(
            producePath = {
                val file = File(System.getProperty("user.home"), ".koobies/$dataStoreFileName")
                file.parentFile?.mkdirs()
                file.absolutePath
            }
        )
    }
}