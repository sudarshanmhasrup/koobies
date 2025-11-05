package user.onboarding.feature.presentation.pages.language

import user.onboarding.feature.domain.model.language.AppLanguageUi

internal data class LanguagePageUiState(val supportedAppLanguages: List<AppLanguageUi> = emptyList())