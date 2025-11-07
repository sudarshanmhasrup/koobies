package compose.shared.app.presentation.theme

import javax.swing.UIManager

internal actual fun isSystemInDarkMode(): Boolean {
    return UIManager.getBoolean("dark.mode")
}