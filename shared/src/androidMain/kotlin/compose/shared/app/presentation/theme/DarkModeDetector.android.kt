package compose.shared.app.presentation.theme

import android.content.Context
import android.content.res.Configuration
import org.koin.java.KoinJavaComponent

internal actual fun isSystemInDarkMode(): Boolean {
    val context: Context by KoinJavaComponent.inject(clazz = Context::class.java)
    val configuration = context.resources.configuration
    val currentNightMode = configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
    return currentNightMode == Configuration.UI_MODE_NIGHT_YES
}