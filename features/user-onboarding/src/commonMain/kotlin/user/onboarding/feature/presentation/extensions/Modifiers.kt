package user.onboarding.feature.presentation.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal fun BoxScope.userOnboardingNavigationCardModifier(backgroundColor: Color): Modifier {
    val cardShape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
    return Modifier
        .fillMaxWidth(0.32f)
        .padding(top = 80.dp)
        .align(alignment = Alignment.Center)
        .clip(shape = cardShape)
        .background(color = backgroundColor)
        .padding(all = 12.dp)
}

internal fun RowScope.desktopLayoutIllustrationContainerModifier(): Modifier {
    return Modifier
        .fillMaxHeight()
        .weight(1.2f)
}

internal fun Modifier.greetingsAndMessageModifier(isLandscapeMode: Boolean = false): Modifier {
    val topPadding = if (isLandscapeMode) 20.dp else 80.dp
    return this
        .fillMaxWidth()
        .padding(top = topPadding, bottom = 0.dp, start = 20.dp, end = 20.dp)
}

@Composable
internal fun BoxScope.continueButtonBackgroundModifier(): Modifier {
    return Modifier
        .navigationBarsPadding()
        .padding(horizontal = 20.dp, vertical = 8.dp)
        .align(alignment = Alignment.BottomEnd)
}

internal fun Modifier.headingAndMessageModifier(isLandscapeMode: Boolean = false): Modifier {
    val topPadding = if (isLandscapeMode) 20.dp else 80.dp
    return this
        .fillMaxWidth()
        .padding(top = topPadding, bottom = 0.dp, start = 20.dp, end = 20.dp)
}