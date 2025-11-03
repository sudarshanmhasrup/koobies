package user.onboarding.feature.data.datasource.local.theme

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.domain.model.theme.AppTheme

@Suppress("ComposableNaming")
internal interface LocalThemeDataSource {
    fun getSupportedAppThemes(): Flow<List<AppTheme>>
    fun updateSelectedAppTheme(theme: AppTheme)
}