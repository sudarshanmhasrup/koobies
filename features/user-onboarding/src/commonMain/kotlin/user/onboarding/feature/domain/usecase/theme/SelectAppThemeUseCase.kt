package user.onboarding.feature.domain.usecase.theme

import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.repository.theme.ThemeRepository

internal class SelectAppThemeUseCase(private val repository: ThemeRepository) {
    suspend operator fun invoke(theme: AppTheme) {
        repository.updateSelectedAppTheme(theme = theme)
    }
}