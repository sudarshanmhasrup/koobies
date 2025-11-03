package user.onboarding.feature.presentation.pages.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import koobies.shared.app.presentation.composeApp.ComposeAppViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import user.onboarding.feature.domain.model.theme.AppTheme
import user.onboarding.feature.domain.usecase.theme.GetSupportedAppThemesUseCase
import user.onboarding.feature.domain.usecase.theme.SelectAppThemeUseCase
import kotlin.text.toInt

@Suppress("ViewModelPublicFunctionShouldStartWithOn")
internal class ThemePageViewModel(
    private val getSupportedAppThemesUseCase: GetSupportedAppThemesUseCase,
    private val selectAppThemeUseCase: SelectAppThemeUseCase,
    private val composeAppViewModel: ComposeAppViewModel
) : ViewModel() {
    private val _uiState = MutableStateFlow(value = ThemePageUiState())
    val uiState: StateFlow<ThemePageUiState> = _uiState

    init {
        viewModelScope.launch {
            getSupportedAppThemesUseCase.invoke().collect { supportedAppThemes ->
                _uiState.value = _uiState.value.copy(supportedAppThemes = supportedAppThemes)
            }
        }
    }

    fun updateSupportedAppThemes(supportedAppThemes: List<AppTheme>) {
        _uiState.update { value ->
            value.copy(supportedAppThemes = supportedAppThemes)
        }
    }

    fun updateSelectedAppTheme(theme: AppTheme) {
        viewModelScope.launch {
            selectAppThemeUseCase.invoke(theme = theme)
            composeAppViewModel.setThemeMode(themeCode = theme.themeType.code.toInt())
        }
    }
}