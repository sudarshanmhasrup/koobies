package koobies.compose.app.presentation.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

internal fun Modifier.composeAppModifier(backgroundColor: Color): Modifier {
    return this
        .background(color = backgroundColor)
        .fillMaxSize()
        .statusBarsPadding()
}