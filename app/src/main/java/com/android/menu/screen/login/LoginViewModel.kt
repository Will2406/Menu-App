package com.android.menu.screen.login

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.menu.domain.usecase.GetGoogleSignInClient
import com.android.menu.domain.usecase.CheckLoginSuccessfulWithGoogle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getGoogleSignInClient: GetGoogleSignInClient,
    private val checkLoginSuccessfulWithGoogle: CheckLoginSuccessfulWithGoogle
) : ViewModel() {

    private val _viewState = MutableStateFlow(LoginUiState())
    val viewState: StateFlow<LoginUiState> = _viewState.asStateFlow()


    fun loginWithGoogle(googleSignInLauncher: ActivityResultLauncher<Intent>) {
        viewModelScope.launch {
            googleSignInLauncher.launch(getGoogleSignInClient.invoke())
        }
    }

    fun checkLoginSuccessfulWithGoogle(intentResult: Intent?) {
        viewModelScope.launch {
            intentResult?.let { intent ->
                checkLoginSuccessfulWithGoogle.invoke(intent)
                    .collect { checkLoginSuccessfulWithGoogle ->
                        _viewState.update { it.copy(checkLoginSuccessful = checkLoginSuccessfulWithGoogle) }
                    }
            }
        }
    }

    fun login() {
        _viewState.update { it.copy(checkLoginSuccessful = true) }
    }
}