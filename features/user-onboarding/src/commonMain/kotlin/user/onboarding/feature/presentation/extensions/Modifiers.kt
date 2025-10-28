package user.onboarding.feature.presentation.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.design.system.api.ComposeAppTheme

internal fun Modifier.greetingsAndMessageModifier(): Modifier {
    return this
        .fillMaxWidth()
        .padding(top = 80.dp, bottom = 0.dp, start = 20.dp, end = 20.dp)
}

@Composable
internal fun BoxScope.userOnboardingNavigationCardModifier(): Modifier {
    val cardShape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)

    return Modifier
        .fillMaxWidth(0.32f)
        .padding(top = 80.dp)
        .align(alignment = Alignment.Center)
        .shadow(
            elevation = 24.dp,
            shape = cardShape,
            ambientColor = Color(0xFF777680).copy(alpha = 0.84f),
            spotColor = Color.Black.copy(alpha = 0.12f)
        )
        .clip(shape = cardShape)
        .background(color = ComposeAppTheme.colorScheme.backgroundColor)
        .padding(all = 12.dp)
}