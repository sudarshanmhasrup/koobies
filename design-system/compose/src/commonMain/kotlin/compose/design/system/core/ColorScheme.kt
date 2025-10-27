package compose.design.system.core

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Represents a collection of colors used for theming in the application.
 * This class is marked as @immutable to ensure thread-safety and prevent modifications after creation.
 */
@Immutable
data class ColorScheme(
    /**
     * The main background color used throughout the application.
     * Defaults to Color.Unspecified if no color is provided.
     *
     * @property backgroundColor The color to be used for backgrounds.
     */
    val backgroundColor: Color = Color.Unspecified
)