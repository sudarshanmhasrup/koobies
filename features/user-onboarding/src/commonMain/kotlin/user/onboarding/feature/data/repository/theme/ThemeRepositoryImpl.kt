package user.onboarding.feature.data.repository.theme

import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.data.datasource.local.theme.LocalThemeDataSource
import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.repository.theme.ThemeRepository

internal class ThemeRepositoryImpl(private val dataSource: LocalThemeDataSource) : ThemeRepository {
    override fun getSupportedAppThemes(): Flow<List<AppTheme>> {
        return dataSource.getSupportedAppThemes()
    }

    override fun updateSelectedAppTheme(theme: AppTheme) {
        dataSource.updateSelectedAppTheme(theme = theme)
    }
}