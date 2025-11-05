package koobies.shared.app.presentation.system

import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarStyleDarkContent
import platform.UIKit.UIStatusBarStyleLightContent
import platform.UIKit.setStatusBarStyle

@Suppress(names = ["EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING"])
internal actual class SystemBarThemeManager {
    actual fun setDarkMode() {
        UIApplication.sharedApplication.setStatusBarStyle(
            statusBarStyle = UIStatusBarStyleLightContent,
            animated = true
        )
    }

    actual fun setLightMode() {
        UIApplication.sharedApplication.setStatusBarStyle(statusBarStyle = UIStatusBarStyleDarkContent, animated = true)
    }
}