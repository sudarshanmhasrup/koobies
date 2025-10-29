package org.koobies.desktop.presentation.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

internal fun Modifier.splashScreenModifier(): Modifier {
    return this
        .clip(shape = RoundedCornerShape(size = 12.dp))
        .background(color = Color.Black)
        .fillMaxSize()
}

internal fun ColumnScope.splashScreenLogoAndContainerModifier(): Modifier {
    return Modifier
        .fillMaxWidth()
        .weight(1f)
}

internal fun Modifier.splashScreenProgressBarModifier(): Modifier {
    return this
        .fillMaxWidth()
        .height(6.dp)
}

internal fun BoxScope.splashScreenLogoModifier(): Modifier {
    return Modifier
        .height(68.dp)
        .align(alignment = Alignment.Center)
}