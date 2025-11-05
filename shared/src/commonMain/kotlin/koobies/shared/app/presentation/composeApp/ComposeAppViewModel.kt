package koobies.shared.app.presentation.composeApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.sudarshanmhasrup.localina.api.LocaleUpdater
import koobies.shared.app.data.preferences.PreferencesManager
import koobies.shared.app.presentation.splash.SplashScreenManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ComposeAppViewModel(private val preferencesManager: PreferencesManager) : ViewModel() {
    private val _uiState = MutableStateFlow(value = ComposeAppUiState())
    val uiState: StateFlow<ComposeAppUiState> = _uiState

    init {
        viewModelScope.launch {
            val selectedAppLanguage = preferencesManager.getSelectedAppLanguage()
            val selectedAppTheme = preferencesManager.getSelectedAppTheme()

            combine(selectedAppLanguage, selectedAppTheme) { selectedAppLanguage, selectedAppTheme ->
                LocaleUpdater.updateLocale(locale = selectedAppLanguage)
                onChangeTheme(theme = selectedAppTheme)
            }.collect {
                SplashScreenManager.markUiAsReady()
            }
        }
    }

    fun onChangeTheme(theme: String) {
        _uiState.update { value ->
            value.copy(
                isDarkMode = when(theme) {
                    "System" -> true
                    "Light" -> false
                    else -> true
                }
            )
        }
    }
}