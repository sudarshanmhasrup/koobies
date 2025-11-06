package user.onboarding.feature.presentation.extensions

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut

internal fun languagePageExitTransitionAnimation(): ExitTransition {
    return fadeOut(animationSpec = tween(300)) + scaleOut(targetScale = 0.9f, animationSpec = tween(300))
}

internal fun languagePageEnterTransitionAnimation(): EnterTransition {
    return fadeIn(animationSpec = tween(300)) + scaleIn(initialScale = 1.1f, animationSpec = tween(300))
}