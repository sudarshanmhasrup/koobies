package user.onboarding.feature.presentation.model.language

import user.onboarding.feature.domain.model.language.AppLanguage

internal data class AppLanguageUi(
    val appLanguage: AppLanguage,
    val isSelected: Boolean
)