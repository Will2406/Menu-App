package com.android.menu.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.menu.domain.usecase.CheckSession
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InitialViewModel @Inject constructor(
    private val checkSession: CheckSession
) : ViewModel() {

    private val _viewState = MutableStateFlow(InitialUiState())
    val viewState: StateFlow<InitialUiState> = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _viewState.update { _viewState.value.copy(isSplashLoading = false, isLoginSuccessful = checkSession.invoke()) }
        }
    }
}