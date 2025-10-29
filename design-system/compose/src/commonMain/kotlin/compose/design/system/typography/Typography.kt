package compose.design.system.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class Typography(
    // Type: Display Large
    val displayLargeRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    val displayLargeMedium: TextStyle = displayLargeRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val displayLargeSemiBold: TextStyle = displayLargeRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val displayLargeBold: TextStyle = displayLargeRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Display Medium
    val displayMediumRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 45.sp,
        lineHeight = 54.sp,
        letterSpacing = 0.sp
    ),
    val displayMediumMedium: TextStyle = displayMediumRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val displayMediumSemiBold: TextStyle = displayMediumRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val displayMediumBold: TextStyle = displayMediumRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Display Small
    val displaySmallRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),
    val displaySmallMedium: TextStyle = displaySmallRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val displaySmallSemiBold: TextStyle = displaySmallRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val displaySmallBold: TextStyle = displaySmallRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Headline Large
    val headlineLargeRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    val headlineLargeMedium: TextStyle = headlineLargeRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val headlineLargeSemiBold: TextStyle = headlineLargeRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val headlineLargeBold: TextStyle = headlineLargeRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Headline Medium
    val headlineMediumRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    val headlineMediumMedium: TextStyle = headlineMediumRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val headlineMediumSemiBold: TextStyle = headlineMediumRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val headlineMediumBold: TextStyle = headlineMediumRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Headline Small
    val headlineSmallRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    val headlineSmallMedium: TextStyle = headlineSmallRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val headlineSmallSemiBold: TextStyle = headlineSmallRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val headlineSmallBold: TextStyle = headlineSmallRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Title Large
    val titleLargeRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    val titleLargeMedium: TextStyle = titleLargeRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val titleLargeSemiBold: TextStyle = titleLargeRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val titleLargeBold: TextStyle = titleLargeRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Title Medium
    val titleMediumRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    val titleMediumMedium: TextStyle = titleMediumRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val titleMediumSemiBold: TextStyle = titleMediumRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val titleMediumBold: TextStyle = titleMediumRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Title Small
    val titleSmallRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    val titleSmallMedium: TextStyle = titleSmallRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val titleSmallSemiBold: TextStyle = titleSmallRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val titleSmallBold: TextStyle = titleSmallRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Body Large
    val bodyLargeRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    val bodyLargeMedium: TextStyle = bodyLargeRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val bodyLargeSemiBold: TextStyle = bodyLargeRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val bodyLargeBold: TextStyle = bodyLargeRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Body Medium
    val bodyMediumRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 14.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.25.sp
    ),
    val bodyMediumMedium: TextStyle = bodyMediumRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val bodyMediumSemiBold: TextStyle = bodyMediumRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val bodyMediumBold: TextStyle = bodyMediumRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Body Small
    val bodySmallRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    val bodySmallMedium: TextStyle = bodySmallRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val bodySmallSemiBold: TextStyle = bodySmallRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val bodySmallBold: TextStyle = bodySmallRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Label Large
    val labelLargeRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    val labelLargeMedium: TextStyle = labelLargeRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val labelLargeSemiBold: TextStyle = labelLargeRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val labelLargeBold: TextStyle = labelLargeRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Label Medium
    val labelMediumRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    val labelMediumMedium: TextStyle = labelMediumRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val labelMediumSemiBold: TextStyle = labelMediumRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val labelMediumBold: TextStyle = labelMediumRegular.copy(fontWeight = FontWeight.Companion.Bold),

    // Type: Label Small
    val labelSmallRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Companion.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    val labelSmallMedium: TextStyle = labelSmallRegular.copy(fontWeight = FontWeight.Companion.Medium),
    val labelSmallSemiBold: TextStyle = labelSmallRegular.copy(fontWeight = FontWeight.Companion.SemiBold),
    val labelSmallBold: TextStyle = labelSmallRegular.copy(fontWeight = FontWeight.Companion.Bold)
)