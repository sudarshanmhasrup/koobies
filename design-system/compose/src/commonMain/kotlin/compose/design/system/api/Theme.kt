package compose.design.system.api

import androidx.compose.runtime.Composable
import compose.design.system.color.ColorScheme
import compose.design.system.color.LocalColorScheme
import compose.design.system.typography.LocalTypography
import compose.design.system.typography.Typography

/**
 * Central access point for design system theme values.
 *
 * This object gives you easy access to colors and text styles.
 * Instead of passing theme objects through many function parameters, use [Theme.colorScheme] and [Theme.typography] to
 * get current values.
 *
 * Example usage in any Composable:
 * ```
 * @Composable
 * fun MyButton() {
 *     Text(
 *         text = "Click me",
 *         style = Theme.typography.displayLargeRegular,
 *         color = Theme.colorScheme.primaryColor
 *     )
 * }
 * ```
 *
 * These properties automatically update when theme changes occur.
 */
object Theme {
    val colorScheme: ColorScheme
        @Composable
        get() = LocalColorScheme.current
    val typography: Typography
        @Composable
        get() = LocalTypography.current
}