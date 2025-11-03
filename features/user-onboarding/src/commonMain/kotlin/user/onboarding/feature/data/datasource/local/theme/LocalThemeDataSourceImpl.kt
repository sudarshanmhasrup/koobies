package user.onboarding.feature.data.datasource.local.theme

import androidx.compose.runtime.Composable
import koobies.shared.app.resources.Res
import koobies.shared.app.resources.dark_theme_type_message
import koobies.shared.app.resources.dark_theme_type_name
import koobies.shared.app.resources.light_theme_type_message
import koobies.shared.app.resources.light_theme_type_name
import koobies.shared.app.resources.system_theme_type_message
import koobies.shared.app.resources.system_theme_type_name
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import org.jetbrains.compose.resources.stringResource
import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.model.theme.ThemeType

internal class LocalThemeDataSourceImpl : LocalThemeDataSource {
    private val supportedAppThemes: MutableStateFlow<List<AppTheme>>
        @Composable
        get() {
            return MutableStateFlow(
                listOf(
                    AppTheme(
                        name = stringResource(resource = Res.string.system_theme_type_name),
                        message = stringResource(resource = Res.string.system_theme_type_message),
                        isSelected = true,
                        themeType = ThemeType.System
                    ),
                    AppTheme(
                        name = stringResource(resource = Res.string.light_theme_type_name),
                        message = stringResource(resource = Res.string.light_theme_type_message),
                        isSelected = false,
                        themeType = ThemeType.Light
                    ),
                    AppTheme(
                        name = stringResource(resource = Res.string.dark_theme_type_name),
                        message = stringResource(resource = Res.string.dark_theme_type_message),
                        isSelected = false,
                        themeType = ThemeType.Dark
                    )
                )
            )
        }

    @Composable
    override fun getSupportedAppThemes(): Flow<List<AppTheme>> {
        return supportedAppThemes
    }

    @Composable
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