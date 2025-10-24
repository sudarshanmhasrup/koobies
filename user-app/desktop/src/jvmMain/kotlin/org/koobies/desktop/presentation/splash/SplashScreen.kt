package org.koobies.desktop.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberWindowState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import koobies.shared.app.resources.Res
import koobies.shared.app.resources.ic_koobies_desktop
import koobies.shared.app.resources.koobies_logo
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koobies.desktop.presentation.extensions.splashScreenLogoAndContainerModifier
import org.koobies.desktop.presentation.extensions.splashScreenLogoModifier
import org.koobies.desktop.presentation.extensions.splashScreenProgressBarModifier
import kotlin.system.exitProcess

private val windowWidth = 860.dp
private val windowHeight = 540.dp

@Composable
internal fun SplashScreen(modifier: Modifier = Modifier) {
    val windowState = rememberWindowState(
        width = windowWidth,
        height = windowHeight,
        position = WindowPosition(alignment = Alignment.Center)
    )

    Window(
        title = "Koobies",
        resizable = false,
        alwaysOnTop = true,
        undecorated = true,
        transparent = true,
        state = windowState,
        icon = painterResource(resource = Res.drawable.ic_koobies_desktop),
        onCloseRequest = { exitProcess(0) }
    ) {
        SplashScreenContent(modifier = modifier)
    }
}

@Composable
private fun SplashScreenContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        SplashScreenLogoAndContainer(modifier = splashScreenLogoAndContainerModifier())
        SplashScreenProgressBar(modifier = Modifier.splashScreenProgressBarModifier())
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

@Composable
private fun SplashScreenProgressBar(modifier: Modifier = Modifier) {
    val splashScreenViewModel = koinViewModel<SplashScreenViewModel>()
    val splashScreenUiState = splashScreenViewModel.uiState.collectAsStateWithLifecycle()
    val progress = splashScreenUiState.value.progress

    LinearProgressIndicator(
        progress = progress,
        backgroundColor = Color(0xFF757780),
        color = Color.White,
        modifier = modifier
    )
}