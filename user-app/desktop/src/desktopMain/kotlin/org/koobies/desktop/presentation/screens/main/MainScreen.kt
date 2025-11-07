package org.koobies.desktop.presentation.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import compose.shared.app.presentation.theme.KoobiesAppTheme
import compose.shared.app.resources.Res
import compose.shared.app.resources.ic_koobies_desktop
import compose.user.app.DesktopApp
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koobies.desktop.presentation.extensions.splashScreenModifier
import org.koobies.desktop.presentation.screens.splash.SplashScreen
import org.koobies.desktop.presentation.screens.splash.SplashScreenViewModel
import kotlin.system.exitProcess

@Composable
internal fun MainScreen() {
    val splashScreenViewModel = koinViewModel<SplashScreenViewModel>()
    val splashScreenUiState = splashScreenViewModel.uiState.collectAsStateWithLifecycle()
    val isFinished = splashScreenUiState.value.isFinished

    if (isFinished) {
        MainWindow()
    } else {
        SplashScreen(modifier = Modifier.splashScreenModifier())
    }
}

@Composable
private fun MainWindow() {
    val windowState = rememberWindowState()

    Window(
        title = "Koobies",
        state = windowState,
        undecorated = false,
        icon = painterResource(resource = Res.drawable.ic_koobies_desktop),
        onCloseRequest = { exitProcess(0) }
    ) {
        KoobiesAppTheme {
            Column(modifier = Modifier.fillMaxSize()) {
                DesktopApp()
            }
        }
    }
}