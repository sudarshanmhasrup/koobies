package user.onboarding.feature.domain.model.theme

internal data class AppTheme(
    val name: String = "",
    val message: String = "",
    val themeType: ThemeType,
    val isSelected: Boolean
)