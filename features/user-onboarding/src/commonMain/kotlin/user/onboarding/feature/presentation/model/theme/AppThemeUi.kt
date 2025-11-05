package user.onboarding.feature.presentation.model.theme

import user.onboarding.feature.domain.model.theme.AppTheme

internal data class AppThemeUi(
    val name: String = "",
    val message: String = "",
    val appTheme: AppTheme,
    val isSelected: Boolean
)