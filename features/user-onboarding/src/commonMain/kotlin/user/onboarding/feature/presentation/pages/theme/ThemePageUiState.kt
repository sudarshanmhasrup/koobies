package user.onboarding.feature.presentation.pages.theme

import user.onboarding.feature.domain.model.theme.AppTheme

internal data class ThemePageUiState(val supportedAppThemes: List<AppTheme> = emptyList())