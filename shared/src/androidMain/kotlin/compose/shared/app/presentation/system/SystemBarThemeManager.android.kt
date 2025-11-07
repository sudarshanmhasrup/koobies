package compose.shared.app.presentation.system

import android.app.Activity
import androidx.core.view.WindowCompat
import org.koin.java.KoinJavaComponent

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual class SystemBarThemeManager {
    private val activity: Activity by KoinJavaComponent.inject(Activity::class.java)
    actual fun setDarkMode() {
        WindowCompat.getInsetsController(activity.window, activity.window.decorView).apply {
            isAppearanceLightStatusBars = false
            isAppearanceLightNavigationBars = false
        }
    }

    actual fun setLightMode() {
        WindowCompat.getInsetsController(activity.window, activity.window.decorView).apply {
            isAppearanceLightStatusBars = true
            isAppearanceLightNavigationBars = true
        }
    }
}