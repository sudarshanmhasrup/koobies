package user.onboarding.feature.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import compose.shared.app.resources.Res
import compose.shared.app.resources.welcome_illustration
import org.jetbrains.compose.resources.painterResource
import user.onboarding.feature.presentation.extensions.desktopLayoutIllustrationContainerModifier
import user.onboarding.feature.presentation.extensions.desktopLayoutNavigationContainerModifier
import user.onboarding.feature.presentation.extensions.languagePageEnterTransitionAnimation
import user.onboarding.feature.presentation.extensions.languagePageExitTransitionAnimation
import user.onboarding.feature.presentation.pages.landing.LandingPage
import user.onboarding.feature.presentation.pages.language.LanguagePage
import user.onboarding.feature.presentation.pages.theme.ThemePage

@Composable
fun UserOnboardingNavigation(
    userOnboardingNavHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        DesktopLayout(
            userOnboardingNavHostController = userOnboardingNavHostController,
            modifier = modifier
        )
    }
}

@Composable
private fun DesktopLayout(
    userOnboardingNavHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        // Illustration container
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = desktopLayoutIllustrationContainerModifier()
        ) {
            Image(
                painter = painterResource(resource = Res.drawable.welcome_illustration),
                contentDescription = null,
                modifier = Modifier.height(480.dp)
            )
        }
        // Navigation container
        Box(modifier = desktopLayoutNavigationContainerModifier()) {
            UserOnboardingNavigationHost(
                userOnboardingNavHostController = userOnboardingNavHostController,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun UserOnboardingNavigationHost(
    userOnboardingNavHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val commonSizeModifier = Modifier.fillMaxSize()

    CompositionLocalProvider(LocalUserOnboardingNavHostController provides userOnboardingNavHostController) {
        NavHost(
            navController = userOnboardingNavHostController,
            startDestination = UserOnboardingRoute.LanguagePage,
            modifier = modifier
        ) {
            composable<UserOnboardingRoute.LanguagePage>(
                enterTransition = { languagePageEnterTransitionAnimation() },
                exitTransition = { languagePageExitTransitionAnimation() }
            ) {
                LanguagePage(modifier = commonSizeModifier)
            }
            composable<UserOnboardingRoute.ThemePage>(
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(300)
                    ) + fadeIn(animationSpec = tween(300))
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(300)
                    ) + fadeOut(animationSpec = tween(300))
                }
            ) {
                ThemePage(modifier = commonSizeModifier)
            }
            composable<UserOnboardingRoute.LandingPage> {
                LandingPage(modifier = commonSizeModifier)
            }
        }
    }
}