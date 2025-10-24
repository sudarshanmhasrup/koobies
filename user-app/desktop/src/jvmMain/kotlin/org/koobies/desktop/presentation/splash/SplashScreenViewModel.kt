package org.koobies.desktop.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class SplashScreenViewModel : ViewModel() {
    var uiState = MutableStateFlow(value = SplashScreenUiState())
        private set

    init {
        viewModelScope.launch {
            // Simulate loading progress
            for (i in 1..10) {
                delay(48)
                uiState.update { state ->
                    state.copy(progress = i.toFloat() / 10f)
                }
            }

            // Update splash screen as finished
            uiState.update { state ->
                state.copy(isFinished = true)
            }
        }
    }
}