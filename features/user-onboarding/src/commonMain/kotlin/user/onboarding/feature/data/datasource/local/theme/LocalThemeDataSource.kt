package user.onboarding.feature.data.datasource.local.theme

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.theme.AppTheme

internal interface LocalThemeDataSource {
    fun getThemes(): Flow<List<AppTheme>>
    suspend fun updateSelectedTheme(theme: AppTheme)
}