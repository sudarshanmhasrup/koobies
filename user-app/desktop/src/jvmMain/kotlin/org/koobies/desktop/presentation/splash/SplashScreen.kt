package org.koobies.desktop.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberWindowState
import koobies.shared.app.resources.Res
import koobies.shared.app.resources.koobies_logo
import org.jetbrains.compose.resources.painterResource
import org.koobies.desktop.presentation.extensions.splashScreenContentModifier
import org.koobies.desktop.presentation.extensions.splashScreenLogoModifier

private val windowWidth = 860.dp
private val windowHeight = 540.dp

@Composable
fun SplashScreen() {
    val windowState = rememberWindowState(
        width = windowWidth,
        height = windowHeight,
        position = WindowPosition(alignment = Alignment.Center)
    )

    Window(alwaysOnTop = false, undecorated = true, transparent = true, state = windowState, onCloseRequest = {}) {
        SplashScreenContent(modifier = Modifier.splashScreenContentModifier())
    }
}

@Composable
private fun SplashScreenContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        SplashScreenLogoAndContainer(modifier = Modifier.fillMaxSize())
    }
}

@Composable
private fun SplashScreenLogoAndContainer(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(resource = Res.drawable.koobies_logo),
            contentDescription = "Koobies Logo",
            modifier = splashScreenLogoModifier()
        )
    }
}