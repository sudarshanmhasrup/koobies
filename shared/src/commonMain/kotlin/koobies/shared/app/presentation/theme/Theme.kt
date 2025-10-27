package koobies.shared.app.presentation.theme

import androidx.compose.runtime.Composable
import compose.design.system.api.ComposeAppTheme
import compose.design.system.core.ColorScheme
import compose.design.system.core.Typography

// Light mode color scheme
internal val lightModeColors = ColorScheme(backgroundColor = backgroundColor)

// Dark mode color scheme
internal val darkModeColors = ColorScheme()

@Composable
fun KoobiesAppTheme(
    isDarkMode: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkMode) darkModeColors else lightModeColors
    ComposeAppTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}