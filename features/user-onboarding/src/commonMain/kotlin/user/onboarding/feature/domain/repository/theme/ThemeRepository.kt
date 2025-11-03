package user.onboarding.feature.domain.repository.theme

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.theme.AppTheme

@Suppress("ComposableNaming")
internal interface ThemeRepository {
    fun getSupportedAppThemes(): Flow<List<AppTheme>>
    fun updateSelectedAppTheme(theme: AppTheme)
}