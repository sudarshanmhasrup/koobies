package koobies.shared.app.presentation.splash

import androidx.compose.runtime.mutableStateOf

object SplashScreenHandler {
    var hide = mutableStateOf(false)
        private set

    fun hideSplashScreen() {
        hide.value = true
    }
}