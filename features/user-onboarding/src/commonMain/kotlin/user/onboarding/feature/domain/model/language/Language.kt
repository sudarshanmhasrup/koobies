package user.onboarding.feature.domain.model.language

internal data class Language(
    val name: String,
    val message: String,
    val locale: String,
    val isSelected: Boolean
)