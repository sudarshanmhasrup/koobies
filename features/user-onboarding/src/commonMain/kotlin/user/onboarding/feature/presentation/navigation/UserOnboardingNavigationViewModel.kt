package user.onboarding.feature.presentation.navigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

internal class UserOnboardingNavigationViewModel : ViewModel() {
    private var navHostController: NavHostController? = null

    fun onGetNavHostController(): NavHostController? {
        return navHostController
    }

    fun onSetNavHostController(navHostController: NavHostController) {
        this.navHostController = navHostController
    }
}