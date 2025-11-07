package compose.user.app.presentation.navigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

internal class ComposeAppNavigationViewModel : ViewModel() {
    private var navHostController: NavHostController? = null

    fun onGetNavHostController(): NavHostController? {
        return navHostController
    }

    fun onSetNavHostController(navHostController: NavHostController) {
        this.navHostController = navHostController
    }
}