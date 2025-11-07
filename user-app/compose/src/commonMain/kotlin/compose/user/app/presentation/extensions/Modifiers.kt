package compose.user.app.presentation.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color

internal fun Modifier.composeAppModifier(backgroundColor: Color): Modifier {
    return this
        .background(color = backgroundColor)
        .fillMaxSize()
        .statusBarsPadding()
}

internal fun BoxScope.navigationBarMaskModifier(backgroundColor: Color): Modifier {
    return Modifier
        .alpha(alpha = 0.5f)
        .background(color = backgroundColor)
        .fillMaxWidth()
        .navigationBarsPadding()
        .align(alignment = Alignment.BottomCenter)
}