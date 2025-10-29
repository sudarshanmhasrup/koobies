package org.koobies.desktop.presentation.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import compose.design.system.api.ComposeAppTheme
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
import java.awt.GraphicsEnvironment
import java.awt.Toolkit
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
        undecorated = true,
        icon = painterResource(resource = Res.drawable.ic_koobies_desktop),
        onCloseRequest = { exitProcess(0) }
    ) {
        // Adjust window bounds manually after creation
        LaunchedEffect(Unit) {
            val gd = GraphicsEnvironment.getLocalGraphicsEnvironment().defaultScreenDevice.defaultConfiguration
            val insets = Toolkit.getDefaultToolkit().getScreenInsets(gd)
            val bounds = gd.bounds
            val usableWidth = bounds.width - (insets.left + insets.right)
            val usableHeight = bounds.height - (insets.top + insets.bottom)

            window.setLocation(insets.left, insets.top)
            window.setSize(usableWidth, usableHeight)
        }

        KoobiesAppTheme {
            Column(modifier = Modifier.fillMaxSize()) {
                CustomTitleBar(modifier = Modifier.fillMaxWidth())
                DesktopApp()
            }
        }
    }
}

@Composable
fun CustomTitleBar(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        CustomTitle(modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp))
    }
}

@Composable
private fun CustomTitle(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(resource = Res.drawable.koobies_logo),
            contentDescription = "Koobies Logo",
            colorFilter = ColorFilter.tint(color = ComposeAppTheme.colorScheme.primaryFontColor),
            modifier = Modifier.height(20.dp)
        )
    }
}