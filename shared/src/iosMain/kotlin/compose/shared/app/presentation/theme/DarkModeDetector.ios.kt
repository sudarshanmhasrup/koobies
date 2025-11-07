package compose.shared.app.presentation.theme

import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

@OptIn(ExperimentalForeignApi::class)
internal actual fun isSystemInDarkMode(): Boolean {
    val userInterfaceStyle = UIScreen.mainScreen.traitCollection.userInterfaceStyle
    return userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark
}