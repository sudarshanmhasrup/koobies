package org.koobies.desktop.presentation.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import compose.design.system.api.Theme
import koobies.compose.app.DesktopApp
import koobies.shared.app.presentation.theme.KoobiesAppTheme
import koobies.shared.app.resources.Res
import koobies.shared.app.resources.ic_koobies_desktop
import koobies.shared.app.resources.koobies_logo
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koobies.desktop.presentation.extensions.splashScreenModifier
import org.koobies.desktop.presentation.screens.splash.SplashScreen
import org.koobies.desktop.presentation.screens.splash.SplashScreenViewModel
import javax.swing.JFrame
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
//                CustomTitleBar(window = window, modifier = Modifier.fillMaxWidth())
                DesktopApp()
            }
        }
    }
}

@Composable
fun CustomTitleBar(window: JFrame, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        CustomTitle(modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp))
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
private fun CustomTitle(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(resource = Res.drawable.koobies_logo),
            contentDescription = "Koobies Logo",
            colorFilter = ColorFilter.tint(color = Theme.colorScheme.primaryFontColor),
            modifier = Modifier.height(20.dp)
        )
    }
}