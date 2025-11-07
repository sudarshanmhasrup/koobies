package compose.user.app.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import compose.shared.app.presentation.navigation.ComposeAppRoute
import compose.shared.app.presentation.theme.KoobiesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import user.onboarding.feature.presentation.navigation.UserOnboardingNavigation

@Composable
internal fun ComposeAppNavigation(
    composeAppNavHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val commonSizeModifier = Modifier.fillMaxSize()
    NavHost(
        navController = composeAppNavHostController,
        startDestination = ComposeAppRoute.UserOnboarding,
        modifier = modifier
    ) {
        composable<ComposeAppRoute.UserOnboarding> {
            UserOnboardingNavigation(modifier = commonSizeModifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ComposeAppNavigationPreview() {
    KoobiesAppTheme(isDarkMode = false) {
        ComposeAppNavigation(composeAppNavHostController = rememberNavController(), modifier = Modifier.fillMaxSize())
    }
}