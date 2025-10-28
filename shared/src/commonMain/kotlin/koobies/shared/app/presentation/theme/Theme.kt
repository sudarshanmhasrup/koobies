package koobies.shared.app.presentation.theme

import androidx.compose.runtime.Composable
import compose.design.system.api.ComposeAppTheme
import compose.design.system.core.ColorScheme

// Light mode color scheme
internal val lightModeColors = ColorScheme(backgroundColor = backgroundColorLight)

// Dark mode color scheme
internal val darkModeColors = ColorScheme(backgroundColor = backgroundColorDark)

@Composable
fun KoobiesAppTheme(
    isDarkMode: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkMode) darkModeColors else lightModeColors
    val typography = getTypography()

    ComposeAppTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}