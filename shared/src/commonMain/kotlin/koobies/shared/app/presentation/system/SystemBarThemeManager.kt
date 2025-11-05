package koobies.shared.app.presentation.system

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal expect class SystemBarThemeManager() {
    fun setDarkMode()
    fun setLightMode()
}