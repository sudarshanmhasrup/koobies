package koobies.shared.app.presentation.system

/**
 * Manages system status bar and navigation bar theme for light/dark modes.
 * Uses platform-specific APIs to control appearance.
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal expect class SystemBarThemeManager() {
    fun setDarkMode()
    fun setLightMode()
}