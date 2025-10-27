package compose.design.system.api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import compose.design.system.core.ColorScheme
import compose.design.system.core.Typography

object ComposeAppTheme {
    val colorScheme: ColorScheme
        @Composable
        get() = LocalColorScheme.current
    val typography: Typography
        @Composable
        get() = LocalTypography.current
}

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