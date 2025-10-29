package compose.design.system.api

import androidx.compose.runtime.Composable
import compose.design.system.color.ColorScheme
import compose.design.system.color.LocalColorScheme
import compose.design.system.typography.LocalTypography
import compose.design.system.typography.Typography

object Theme {
    val colorScheme: ColorScheme
        @Composable
        get() = LocalColorScheme.current
    val typography: Typography
        @Composable
        get() = LocalTypography.current
}