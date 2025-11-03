package user.onboarding.feature.domain.repository.theme

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.theme.AppTheme

@Suppress("ComposableNaming")
internal interface ThemeRepository {
    @Composable
    fun getSupportedAppThemes(): Flow<List<AppTheme>>
    @Composable
    fun updateSelectedAppTheme(theme: AppTheme)
}