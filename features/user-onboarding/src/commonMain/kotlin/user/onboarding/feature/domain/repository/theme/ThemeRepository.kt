package user.onboarding.feature.domain.repository.theme

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.theme.AppTheme

@Suppress("ComposableNaming")
internal interface ThemeRepository {
    fun getSupportedAppThemes(): Flow<List<AppTheme>>
    suspend fun updateSelectedAppTheme(theme: AppTheme)
}