package user.onboarding.feature.data.datasource.local.theme

import koobies.shared.app.data.preferences.PreferencesManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.model.theme.ThemeType

internal class LocalThemeDataSourceImpl(private val preferencesManager: PreferencesManager) : LocalThemeDataSource {
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

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val selectedAppTheme = preferencesManager.getSelectedAppTheme().first()
            if (selectedAppTheme.isEmpty()) {
                return@launch
            }

            updateSelectedAppTheme(theme = selectedAppTheme)
        }
    }

    override fun getSupportedAppThemes(): Flow<List<AppTheme>> {
        return supportedAppThemes
    }

    override suspend fun updateSelectedAppTheme(theme: String) {
        supportedAppThemes.update { value ->
            value.map {
                if (it.themeType.code == theme) {
                    it.copy(isSelected = true)
                } else {
                    it.copy(isSelected = false)
                }
            }
        }
    }
}