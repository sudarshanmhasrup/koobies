package user.onboarding.feature.data.datasource.local.theme

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.theme.AppTheme

@Suppress("ComposableNaming")
internal interface LocalThemeDataSource {
    @Composable
    fun getSupportedAppThemes(): Flow<List<AppTheme>>
    @Composable
    fun updateSelectedAppTheme(theme: AppTheme)
}