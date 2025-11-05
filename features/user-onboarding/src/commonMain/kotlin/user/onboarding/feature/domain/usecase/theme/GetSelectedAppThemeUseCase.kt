package user.onboarding.feature.domain.usecase.theme

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.repository.theme.ThemeRepository

internal class GetSelectedAppThemeUseCase(private val repository: ThemeRepository) {
    operator fun invoke(): Flow<String> {
        return repository.getSelectedAppTheme()
    }
}