package user.onboarding.feature.data.datasource.local.theme

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.model.theme.ThemeType

internal class LocalThemeDataSourceImpl : LocalThemeDataSource {
    private val supportedAppThemes = MutableStateFlow(
        listOf(
            AppTheme(
                isSelected = true,
                themeType = ThemeType.System
            ),
            AppTheme(
                isSelected = false,
                themeType = ThemeType.Light
            ),
            AppTheme(
                isSelected = false,
                themeType = ThemeType.Dark
            )
        )
    )

    override fun getSupportedAppThemes(): Flow<List<AppTheme>> {
        return supportedAppThemes
    }

    override fun updateSelectedAppTheme(theme: AppTheme) {
        supportedAppThemes.update { value ->
            value.map {
                if (it.themeType == theme.themeType) {
                    it.copy(isSelected = true)
                } else {
                    it.copy(isSelected = false)
                }
            }
        }
    }
}