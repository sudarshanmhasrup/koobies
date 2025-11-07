package compose.shared.app.presentation.theme

/**
 * Detects the system's current theme preference (dark or light mode).
 * Uses platform-specific APIs to check the device or OS theme settings.
 *
 * @return true if system is in dark mode, false if in light mode
 */
internal expect fun isSystemInDarkMode(): Boolean