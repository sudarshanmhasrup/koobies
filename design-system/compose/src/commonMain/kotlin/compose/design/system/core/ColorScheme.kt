package compose.design.system.core

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class ColorScheme(
    val backgroundColor: Color = Color.Unspecified,
    val primaryColor: Color = Color.Unspecified,
    val primaryFontColor: Color = Color.Unspecified,
    val secondaryFontColor: Color = Color.Unspecified
)