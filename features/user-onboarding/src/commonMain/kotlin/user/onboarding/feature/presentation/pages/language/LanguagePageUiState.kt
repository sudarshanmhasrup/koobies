package user.onboarding.feature.presentation.pages.language

import user.onboarding.feature.domain.model.language.AppLanguage

internal data class LanguagePageUiState(val supportedAppLanguages: List<AppLanguage> = emptyList())