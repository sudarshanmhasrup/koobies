package compose.design.system.api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import compose.design.system.color.ColorScheme
import compose.design.system.color.LocalColorScheme
import compose.design.system.typography.LocalTypography
import compose.design.system.typography.Typography

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