package user.onboarding.feature.presentation.pages.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.sudarshanmhasrup.localina.api.LocaleUpdater
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import user.onboarding.feature.domain.model.language.AppLanguage
import user.onboarding.feature.domain.usecase.language.GetSelectedAppLanguageUseCase
import user.onboarding.feature.domain.usecase.language.GetSupportedAppLanguagesUseCase
import user.onboarding.feature.domain.usecase.language.SelectAppLanguageUseCase
import user.onboarding.feature.presentation.model.language.AppLanguageUi

internal class LanguagePageViewModel(
    private val getSupportedAppLanguagesUseCase: GetSupportedAppLanguagesUseCase,
    private val selectAppLanguageUseCase: SelectAppLanguageUseCase,
    private val getSelectedAppLanguageUseCase: GetSelectedAppLanguageUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(value = LanguagePageUiState())
    val uiState: StateFlow<LanguagePageUiState> = _uiState

    init {
        viewModelScope.launch {
            combine(
                getSupportedAppLanguagesUseCase(),
                getSelectedAppLanguageUseCase()
            ) { supportedLanguages, selectedLanguage ->
                supportedLanguages.map { language ->
                    AppLanguageUi(
                        appLanguage = language,
                        isSelected = language.locale == selectedLanguage
                    )
                }
            }.collect { supportedAppLanguages ->
                _uiState.update { value ->
                    value.copy(supportedAppLanguages = supportedAppLanguages)
                }
            }
        }
    }

    fun onLanguageSelected(language: AppLanguage) {
        _uiState.update { value ->
            value.copy(supportedAppLanguages = value.supportedAppLanguages.map {
                it.copy(isSelected = it.appLanguage.locale == language.locale)
            })
        }
        LocaleUpdater.updateLocale(locale = language.locale)
        onLanguageSelected()
    }

    fun onLanguageSelected() {
        viewModelScope.launch {
            val currentSelectedLanguage = _uiState.value.supportedAppLanguages.first { it.isSelected }
            selectAppLanguageUseCase.invoke(language = currentSelectedLanguage.appLanguage)
        }
    }
}