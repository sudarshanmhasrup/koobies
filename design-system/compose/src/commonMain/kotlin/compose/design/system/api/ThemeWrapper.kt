package compose.design.system.api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import compose.design.system.color.ColorScheme
import compose.design.system.color.LocalColorScheme
import compose.design.system.typography.LocalTypography
import compose.design.system.typography.Typography

/**
 * Wraps content with the app's design system theme.
 *
 * This function makes colors and typography available to all child composables.
 *
 * Any composable inside [content] can access [Theme.colorScheme] and [Theme.typography] without passing them as
 * parameters.
 *
 * Example usage:
 * ```
 * ThemeWrapper(
 *     colorScheme = lightColorScheme,
 *     typography = appTypography
 * ) {
 *     HomeScreen()
 *     // HomeScreen can now access Theme.colorScheme and Theme.typography
 * }
 * ```
 *
 * @param colorScheme The color palette to use
 * @param typography The text styles to use
 * @param content The UI to wrap with this theme
 */
@Composable
fun ThemeWrapper(
    colorScheme: ColorScheme,
    typography: Typography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalColorScheme provides colorScheme, LocalTypography provides typography) {
        content()
    }
}