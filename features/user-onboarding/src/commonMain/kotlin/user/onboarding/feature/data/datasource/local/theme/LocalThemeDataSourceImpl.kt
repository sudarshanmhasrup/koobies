package user.onboarding.feature.data.datasource.local.theme

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.model.theme.ThemeType

internal class LocalThemeDataSourceImpl : LocalThemeDataSource {
    private val supportedAppThemes = flowOf(
        listOf(
            AppTheme(themeType = ThemeType.System),
            AppTheme(themeType = ThemeType.Light),
            AppTheme(themeType = ThemeType.Dark)
        )
    )

    override fun getSupportedAppThemes(): Flow<List<AppTheme>> {
        return supportedAppThemes
    }
}