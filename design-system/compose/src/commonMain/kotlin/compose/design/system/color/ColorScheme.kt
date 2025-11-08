package compose.design.system.color

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Koobies design system color palette.
 *
 * Defines all color tokens for consistent theming across all platforms (Android, iOS, Desktop).
 *
 * Colors are designed to work with both light and dark modes, providing a flexible color system that can be extended
 * with additional colors as needed.
 */
@Immutable
data class ColorScheme(
    val backgroundColor: Color = Color.Unspecified,
    val primaryColor: Color = Color.Unspecified,
    val secondaryColor: Color = Color.Unspecified,
    val tertiaryColor: Color = Color.Unspecified,
    val primaryFontColor: Color = Color.Unspecified,
    val secondaryFontColor: Color = Color.Unspecified
)