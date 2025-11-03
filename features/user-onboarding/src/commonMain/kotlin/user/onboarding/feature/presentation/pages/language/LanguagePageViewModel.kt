package user.onboarding.feature.presentation.pages.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.sudarshanmhasrup.localina.api.LocaleUpdater
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import user.onboarding.feature.domain.model.language.AppLanguage
import user.onboarding.feature.domain.usecase.language.GetSupportedAppLanguagesUseCase
import user.onboarding.feature.domain.usecase.language.SelectAppLanguageUseCase

internal class LanguagePageViewModel(
    private val getSupportedAppLanguagesUseCase: GetSupportedAppLanguagesUseCase,
    private val selectAppLanguageUseCase: SelectAppLanguageUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(value = LanguagePageUiState())
    val uiState: StateFlow<LanguagePageUiState> = _uiState

    init {
        viewModelScope.launch {
            getSupportedAppLanguagesUseCase.invoke().collect { supportedAppLanguages ->
                _uiState.value = _uiState.value.copy(supportedAppLanguages = supportedAppLanguages)

                val selectedAppLanguage = supportedAppLanguages.find { it.isSelected }
                LocaleUpdater.updateLocale(locale = selectedAppLanguage?.locale ?: "en")
            }
        }
    }

    @Suppress("ViewModelPublicFunctionShouldStartWithOn")
    fun updateSelectedAppLanguage(language: AppLanguage) {
        viewModelScope.launch {
            selectAppLanguageUseCase.invoke(language = language)
        }
    }
}