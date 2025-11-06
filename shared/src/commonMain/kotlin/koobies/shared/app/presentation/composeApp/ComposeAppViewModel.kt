package koobies.shared.app.presentation.composeApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.sudarshanmhasrup.localina.api.LocaleUpdater
import koobies.shared.app.data.preferences.PreferencesManager
import koobies.shared.app.presentation.splash.SplashScreenManager
import koobies.shared.app.presentation.system.SystemBarThemeManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ComposeAppViewModel(private val preferencesManager: PreferencesManager) : ViewModel(), KoinComponent {
    private val systemBarThemeManager by inject<SystemBarThemeManager>()

    private val _uiState = MutableStateFlow(value = ComposeAppUiState())
    val uiState = _uiState.asStateFlow()

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
                isDarkMode = when (theme) {
                    "System" -> {
                        systemBarThemeManager.setDarkMode()
                        true
                    }

                    "Light" -> {
                        systemBarThemeManager.setLightMode()
                        false
                    }

                    else -> {
                        systemBarThemeManager.setDarkMode()
                        true
                    }
                }
            )
        }
    }
}