package compose.design.system.api

import androidx.compose.runtime.staticCompositionLocalOf
import compose.design.system.core.ColorScheme
import compose.design.system.core.Typography

internal val LocalTypography = staticCompositionLocalOf {
    Typography()
}

internal val LocalColorScheme = staticCompositionLocalOf {
    ColorScheme()
}