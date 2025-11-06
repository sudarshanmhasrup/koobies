package koobies.shared.app.presentation.splash

/**
 * Manages the splash screen visibility state.
 * Signals when the UI is ready to be displayed, allowing the splash screen to dismiss.
 */
object SplashScreenManager {
    private var isUiReadyToDraw = false

    fun isUiReady(): Boolean {
        return isUiReadyToDraw
    }

    fun markUiAsReady() {
        isUiReadyToDraw = true
    }
}