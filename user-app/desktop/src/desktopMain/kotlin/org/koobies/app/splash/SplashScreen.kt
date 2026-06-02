package org.koobies.app.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.sudarshanmhasrup.splashify.ui.config.SplashIndicatorStyle
import io.github.sudarshanmhasrup.splashify.ui.config.SplashScreenSize
import io.github.sudarshanmhasrup.splashify.ui.config.SplashScreenStyle
import io.github.sudarshanmhasrup.splashify.ui.splashscreen.ProgressiveSplashScreen
import org.jetbrains.compose.resources.painterResource
import org.koobies.app.desktop.resources.Res
import org.koobies.app.desktop.resources.ic_splash_screen_desktop

@Composable
fun SplashScreen() {
    val size = SplashScreenSize(width = 680.dp, height = 440.dp)
    val style = SplashScreenStyle(backgroundColor = Color.Black, cornerRadius = 16.dp)
    val indicatorStyle = SplashIndicatorStyle(color = Color.White, trackColor = Color.Black, thickness = 6.dp)

    val splashScreenLogo = painterResource(resource = Res.drawable.ic_splash_screen_desktop)

    ProgressiveSplashScreen(size = size, style = style, indicatorStyle = indicatorStyle) {
        Image(painter = splashScreenLogo, contentDescription = "Koobies", modifier = Modifier.height(48.dp))
    }
}