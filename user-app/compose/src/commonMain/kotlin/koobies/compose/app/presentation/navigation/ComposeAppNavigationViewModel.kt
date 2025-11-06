package koobies.compose.app.presentation.navigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

internal class ComposeAppNavigationViewModel : ViewModel() {
    private var navHostController: NavHostController? = null

    fun onCreateNavHostController(navHostController: NavHostController) {
        this.navHostController = navHostController
    }

    fun onGetComposeAppNavHostController(): NavHostController {
        return navHostController!!
    }
}