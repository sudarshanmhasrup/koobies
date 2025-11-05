package koobies.shared.app.presentation.splash

object SplashScreenManager {
    private var isUiReadyToDraw = false

    fun isUiReady(): Boolean {
        return isUiReadyToDraw
    }

    fun markUiAsReady() {
        isUiReadyToDraw = true
    }
}