package compose.shared.app.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import compose.design.system.api.Theme
import compose.design.system.typography.Typography
import koobies.shared.app.resources.Res
import koobies.shared.app.resources.bold
import koobies.shared.app.resources.extra_bold
import koobies.shared.app.resources.medium
import koobies.shared.app.resources.regular
import koobies.shared.app.resources.semibold
import org.jetbrains.compose.resources.Font

@Composable
internal fun getTypography(): Typography {
    val fontFamily = FontFamily(
        Font(resource = Res.font.regular, weight = FontWeight.Normal),
        Font(resource = Res.font.medium, weight = FontWeight.Medium),
        Font(resource = Res.font.semibold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.bold, weight = FontWeight.Bold),
        Font(resource = Res.font.extra_bold, weight = FontWeight.ExtraBold)
    )

    return with(Theme.typography) {
        copy(
            displayLargeRegular = displayLargeRegular.copy(fontFamily = fontFamily),
            displayLargeMedium = displayLargeMedium.copy(fontFamily = fontFamily),
            displayLargeSemiBold = displayLargeSemiBold.copy(fontFamily = fontFamily),
            displayLargeBold = displayLargeBold.copy(fontFamily = fontFamily),

            displayMediumRegular = displayMediumRegular.copy(fontFamily = fontFamily),
            displayMediumMedium = displayMediumMedium.copy(fontFamily = fontFamily),
            displayMediumSemiBold = displayMediumSemiBold.copy(fontFamily = fontFamily),
            displayMediumBold = displayMediumBold.copy(fontFamily = fontFamily),

            displaySmallRegular = displaySmallRegular.copy(fontFamily = fontFamily),
            displaySmallMedium = displaySmallMedium.copy(fontFamily = fontFamily),
            displaySmallSemiBold = displaySmallSemiBold.copy(fontFamily = fontFamily),
            displaySmallBold = displaySmallBold.copy(fontFamily = fontFamily),

            headlineLargeRegular = headlineLargeRegular.copy(fontFamily = fontFamily),
            headlineLargeMedium = headlineLargeMedium.copy(fontFamily = fontFamily),
            headlineLargeSemiBold = headlineLargeSemiBold.copy(fontFamily = fontFamily),
            headlineLargeBold = headlineLargeBold.copy(fontFamily = fontFamily),

            headlineMediumRegular = headlineMediumRegular.copy(fontFamily = fontFamily),
            headlineMediumMedium = headlineMediumMedium.copy(fontFamily = fontFamily),
            headlineMediumSemiBold = headlineMediumSemiBold.copy(fontFamily = fontFamily),
            headlineMediumBold = headlineMediumBold.copy(fontFamily = fontFamily),

            headlineSmallRegular = headlineSmallRegular.copy(fontFamily = fontFamily),
            headlineSmallMedium = headlineSmallMedium.copy(fontFamily = fontFamily),
            headlineSmallSemiBold = headlineSmallSemiBold.copy(fontFamily = fontFamily),
            headlineSmallBold = headlineSmallBold.copy(fontFamily = fontFamily),

            titleLargeRegular = titleLargeRegular.copy(fontFamily = fontFamily),
            titleLargeMedium = titleLargeMedium.copy(fontFamily = fontFamily),
            titleLargeSemiBold = titleLargeSemiBold.copy(fontFamily = fontFamily),
            titleLargeBold = titleLargeBold.copy(fontFamily = fontFamily),

            titleMediumRegular = titleMediumRegular.copy(fontFamily = fontFamily),
            titleMediumMedium = titleMediumMedium.copy(fontFamily = fontFamily),
            titleMediumSemiBold = titleMediumSemiBold.copy(fontFamily = fontFamily),
            titleMediumBold = titleMediumBold.copy(fontFamily = fontFamily),

            titleSmallRegular = titleSmallRegular.copy(fontFamily = fontFamily),
            titleSmallMedium = titleSmallMedium.copy(fontFamily = fontFamily),
            titleSmallSemiBold = titleSmallSemiBold.copy(fontFamily = fontFamily),
            titleSmallBold = titleSmallBold.copy(fontFamily = fontFamily),

            bodyLargeRegular = bodyLargeRegular.copy(fontFamily = fontFamily),
            bodyLargeMedium = bodyLargeMedium.copy(fontFamily = fontFamily),
            bodyLargeSemiBold = bodyLargeSemiBold.copy(fontFamily = fontFamily),
            bodyLargeBold = bodyLargeBold.copy(fontFamily = fontFamily),

            bodyMediumRegular = bodyMediumRegular.copy(fontFamily = fontFamily),
            bodyMediumMedium = bodyMediumMedium.copy(fontFamily = fontFamily),
            bodyMediumSemiBold = bodyMediumSemiBold.copy(fontFamily = fontFamily),
            bodyMediumBold = bodyMediumBold.copy(fontFamily = fontFamily),

            bodySmallRegular = bodySmallRegular.copy(fontFamily = fontFamily),
            bodySmallMedium = bodySmallMedium.copy(fontFamily = fontFamily),
            bodySmallSemiBold = bodySmallSemiBold.copy(fontFamily = fontFamily),
            bodySmallBold = bodySmallBold.copy(fontFamily = fontFamily),

            labelLargeRegular = labelLargeRegular.copy(fontFamily = fontFamily),
            labelLargeMedium = labelLargeMedium.copy(fontFamily = fontFamily),
            labelLargeSemiBold = labelLargeSemiBold.copy(fontFamily = fontFamily),
            labelLargeBold = labelLargeBold.copy(fontFamily = fontFamily),

            labelMediumRegular = labelMediumRegular.copy(fontFamily = fontFamily),
            labelMediumMedium = labelMediumMedium.copy(fontFamily = fontFamily),
            labelMediumSemiBold = labelMediumSemiBold.copy(fontFamily = fontFamily),
            labelMediumBold = labelMediumBold.copy(fontFamily = fontFamily),

            labelSmallRegular = labelSmallRegular.copy(fontFamily = fontFamily),
            labelSmallMedium = labelSmallMedium.copy(fontFamily = fontFamily),
            labelSmallSemiBold = labelSmallSemiBold.copy(fontFamily = fontFamily),
            labelSmallBold = labelSmallBold.copy(fontFamily = fontFamily)
        )
    }
}