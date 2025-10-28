package user.onboarding.feature.domain.model.language

import io.github.sudarshanmhasrup.localina.annoations.ExperimentalLocalinaApi
import io.github.sudarshanmhasrup.localina.api.Locale

@OptIn(ExperimentalLocalinaApi::class)
internal data class Language(
    val name: String,
    val message: String,
    val locale: Locale,
    val isSelected: Boolean
)