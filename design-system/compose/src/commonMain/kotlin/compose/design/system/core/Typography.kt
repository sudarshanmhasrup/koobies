package compose.design.system.core

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class Typography(
    // Type: Display Small
    val displaySmallRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    val displaySmallMedium: TextStyle = displaySmallRegular.copy(fontWeight = FontWeight.Medium),
    val displaySmallSemiBold: TextStyle = displaySmallRegular.copy(fontWeight = FontWeight.SemiBold),
    val displaySmallBold: TextStyle = displaySmallRegular.copy(fontWeight = FontWeight.Bold),

    // Type: Body Large
    val bodyLargeRegular: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 28.sp,
        letterSpacing = (0.25).sp
    ),
    val bodyLargeMedium: TextStyle = bodyLargeRegular.copy(fontWeight = FontWeight.Medium),
    val bodyLargeSemiBold: TextStyle = bodyLargeRegular.copy(fontWeight = FontWeight.SemiBold),
    val bodyLargeBold: TextStyle = bodyLargeRegular.copy(fontWeight = FontWeight.Bold)
)