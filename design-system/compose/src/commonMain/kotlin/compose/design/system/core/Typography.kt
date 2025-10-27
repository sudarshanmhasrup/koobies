package compose.design.system.core

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class Typography(
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