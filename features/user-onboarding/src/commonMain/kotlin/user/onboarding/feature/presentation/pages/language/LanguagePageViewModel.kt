package user.onboarding.feature.presentation.pages.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.sudarshanmhasrup.localina.api.LocaleUpdater
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import user.onboarding.feature.domain.model.language.Language
import user.onboarding.feature.domain.usecase.language.GetLanguagesUseCase
import user.onboarding.feature.domain.usecase.language.SelectLanguageUseCase

internal class LanguagePageViewModel(
    private val getLanguagesUseCase: GetLanguagesUseCase,
    private val selectLanguageUseCase: SelectLanguageUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(value = LanguagePageUiState())
    val uiState: StateFlow<LanguagePageUiState> = _uiState

    init {
        viewModelScope.launch {
            getLanguagesUseCase.invoke().collect { languages ->
                _uiState.value = _uiState.value.copy(languages = languages)

                val selectedLanguage = languages.find { it.isSelected }
                LocaleUpdater.updateLocale(locale = selectedLanguage?.locale ?: "en")
            }
        }
    }

    @Suppress("ViewModelPublicFunctionShouldStartWithOn")
    fun updateSelectedLanguage(language: Language) {
        viewModelScope.launch {
            selectLanguageUseCase.invoke(language = language)
        }
    }
}