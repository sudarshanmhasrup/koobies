package compose.design.system.api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import compose.design.system.core.ColorScheme
import compose.design.system.core.Typography


/**
 * Theme object that provides access to the app's color scheme and typography.
 * Use this to get current theme values in your composable functions.
 */
object ComposeAppTheme {
    val colorScheme: ColorScheme
        @Composable
        get() = LocalColorScheme.current
    val typography: Typography
        @Composable
        get() = LocalTypography.current
}

/**
 * Creates a theme wrapper for your app's content.
 *
 * @param colorScheme The color scheme to use for the app theme.
 * @param typography The typography settings to use for the app theme.
 * @param content The content to be displayed using this theme.
 */
@Composable
fun ComposeAppTheme(
    colorScheme: ColorScheme,
    typography: Typography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalColorScheme provides colorScheme, LocalTypography provides typography) {
        content()
    }
}