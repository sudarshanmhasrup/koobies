package compose.shared.app.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import compose.shared.app.data.preferences.createDataStore
import compose.shared.app.data.preferences.dataStoreFileName
import org.koin.java.KoinJavaComponent

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual class DataStoreManager {
    private val context: Context by KoinJavaComponent.inject(Context::class.java)
    actual fun getDataStore(): DataStore<Preferences> {
        return createDataStore(
            producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
        )
    }
}