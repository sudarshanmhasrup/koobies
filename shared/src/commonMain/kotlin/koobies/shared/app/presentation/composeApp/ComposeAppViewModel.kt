package koobies.shared.app.presentation.composeApp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class ComposeAppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(value = ComposeAppUiState())
    val uiState: StateFlow<ComposeAppUiState> = _uiState
}