package user.onboarding.feature.data.repository.theme

import koobies.shared.app.data.preferences.PreferencesManager
import kotlinx.coroutines.flow.Flow
import user.onboarding.feature.data.datasource.local.theme.LocalThemeDataSource
import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.repository.theme.ThemeRepository

internal class ThemeRepositoryImpl(
    private val dataSource: LocalThemeDataSource,
    private val preferencesManager: PreferencesManager
) : ThemeRepository {
    override fun getSupportedAppThemes(): Flow<List<AppTheme>> {
        return dataSource.getSupportedAppThemes()
    }

    override suspend fun updateSelectedAppTheme(theme: AppTheme) {
        preferencesManager.saveSelectedAppTheme(theme = theme.themeType.code)
    }

    override fun getSelectedAppTheme(): Flow<String> {
        return preferencesManager.getSelectedAppTheme()
    }
}