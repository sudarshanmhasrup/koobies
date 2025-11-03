package user.onboarding.feature.domain.usecase.theme

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.repository.theme.ThemeRepository

internal class GetSupportedAppThemesUseCase(private val themeRepository: ThemeRepository) {
    @Composable
    operator fun invoke(): Flow<List<AppTheme>> {
        return themeRepository.getSupportedAppThemes()
    }
}