package user.onboarding.feature.presentation.pages.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import koobies.shared.app.presentation.composeApp.ComposeAppViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.usecase.theme.GetSelectedAppThemeUseCase
import user.onboarding.feature.domain.usecase.theme.GetSupportedAppThemesUseCase
import user.onboarding.feature.domain.usecase.theme.SelectAppThemeUseCase
import user.onboarding.feature.presentation.model.theme.AppThemeUi

internal class ThemePageViewModel(
    private val getSupportedAppThemesUseCase: GetSupportedAppThemesUseCase,
    private val selectAppThemeUseCase: SelectAppThemeUseCase,
    private val getSelectedAppThemeUseCase: GetSelectedAppThemeUseCase,
    private val composeAppViewModel: ComposeAppViewModel
) : ViewModel() {
    private val _uiState = MutableStateFlow(value = ThemePageUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            combine(
                getSupportedAppThemesUseCase(),
                getSelectedAppThemeUseCase()
            ) { supportedAppThemes, selectedAppTheme ->
                supportedAppThemes.map { theme ->
                    AppThemeUi(
                        appTheme = AppTheme(themeType = theme.themeType),
                        isSelected = theme.themeType.code == selectedAppTheme
                    )
                }
            }.collect { supportedAppThemes ->
                _uiState.update { value ->
                    value.copy(supportedAppThemes = supportedAppThemes)
                }
            }
        }
    }

    fun onUpdateSupportedAppThemes(supportedAppThemes: List<AppThemeUi>) {
        _uiState.update { value ->
            value.copy(supportedAppThemes = supportedAppThemes)
        }
    }

    fun onUpdateSelectedAppTheme(theme: AppTheme) {
        _uiState.update { value ->
            value.copy(supportedAppThemes = value.supportedAppThemes.map {
                it.copy(isSelected = it.appTheme.themeType == theme.themeType)
            })
        }
        composeAppViewModel.onChangeTheme(theme = theme.themeType.code)
        onUpdateSelectedAppTheme()
    }

    fun onUpdateSelectedAppTheme() {
        viewModelScope.launch {
            val selectedAppTheme = _uiState.value.supportedAppThemes.first { it.isSelected }
            selectAppThemeUseCase.invoke(theme = selectedAppTheme.appTheme)
        }
    }
}