package user.onboarding.feature.domain.usecase.theme

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.repository.theme.ThemeRepository

internal class GetSupportedAppThemesUseCase(private val repository: ThemeRepository) {
    operator fun invoke(): Flow<List<AppTheme>> {
        return repository.getSupportedAppThemes()
    }
}