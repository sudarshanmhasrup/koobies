package org.koobies.desktop.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.rememberWindowState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import koobies.shared.app.resources.Res
import koobies.shared.app.resources.ic_koobies_desktop
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koobies.desktop.presentation.extensions.splashScreenContentModifier
import org.koobies.desktop.presentation.splash.SplashScreen
import org.koobies.desktop.presentation.splash.SplashScreenViewModel
import kotlin.system.exitProcess

@Composable
fun MainScreen() {
    val splashScreenViewModel = koinViewModel<SplashScreenViewModel>()
    val splashScreenUiState = splashScreenViewModel.uiState.collectAsStateWithLifecycle()
    val isFinished = splashScreenUiState.value.isFinished

    if (isFinished) {
        MainWindow()
    } else {
        SplashScreen(modifier = Modifier.splashScreenContentModifier())
    }
}

@Composable
private fun MainWindow() {
    val widowState = rememberWindowState(
        placement = WindowPlacement.Maximized
    )

    Window(
        title = "Koobies",
        undecorated = true,
        state = widowState,
        icon = painterResource(resource = Res.drawable.ic_koobies_desktop),
        onCloseRequest = { exitProcess(0) }
    ) {

    }
}