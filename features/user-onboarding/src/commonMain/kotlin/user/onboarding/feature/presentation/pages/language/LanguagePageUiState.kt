package user.onboarding.feature.presentation.pages.language

import user.onboarding.feature.domain.model.language.Language

internal data class LanguagePageUiState(
    val languages: List<Language> = emptyList()
)