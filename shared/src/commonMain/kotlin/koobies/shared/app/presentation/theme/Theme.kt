package koobies.shared.app.presentation.theme

import androidx.compose.runtime.Composable
import compose.design.system.api.ThemeWrapper
import compose.design.system.color.ColorScheme

// Light mode color scheme
internal val lightModeColors = ColorScheme(
    backgroundColor = backgroundColorLight,
    primaryColor = primaryColor,
    tertiaryColor = tertiaryColorLight,
    primaryFontColor = primaryFontColorLight,
    secondaryFontColor = secondaryFontColorLight
)

// Dark mode color scheme
internal val darkModeColors = ColorScheme(
    backgroundColor = backgroundColorDark,
    primaryColor = primaryColor,
    tertiaryColor = tertiaryColorDark,
    primaryFontColor = primaryFontColorDark,
    secondaryFontColor = secondaryFontColorDark
)

@Composable
fun KoobiesAppTheme(
    isDarkMode: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkMode) darkModeColors else lightModeColors
    val typography = getTypography()
    ThemeWrapper(colorScheme = colorScheme, typography = typography, content = content)
}