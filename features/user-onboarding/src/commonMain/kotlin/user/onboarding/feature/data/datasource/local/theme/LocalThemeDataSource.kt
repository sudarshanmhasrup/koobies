package user.onboarding.feature.data.datasource.local.theme

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.theme.AppTheme

@Suppress("ComposableNaming")
internal interface LocalThemeDataSource {
    fun getSupportedAppThemes(): Flow<List<AppTheme>>
    suspend fun updateSelectedAppTheme(theme: String)
}