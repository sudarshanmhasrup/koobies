package user.onboarding.feature.domain.repository.theme

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.theme.AppTheme

internal interface ThemeRepository {
    fun getSupportedAppThemes(): Flow<List<AppTheme>>
    suspend fun updateSelectedAppTheme(theme: AppTheme)
    fun getSelectedAppTheme(): Flow<String>
}