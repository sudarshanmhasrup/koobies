package user.onboarding.feature.presentation.extensions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

internal fun Modifier.greetingsAndMessageModifier(): Modifier {
    return this
        .fillMaxWidth()
        .padding(top = 60.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
}