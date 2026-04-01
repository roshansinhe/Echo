package com.example.echo.login.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.echo.login.model.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import com.example.echo.login.model.LoginData
import com.example.echo.login.model.LoginRequest
import com.example.echo.login.repository.AuthRepository
import com.example.echo.utis.getUtcTimeISO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.time.ExperimentalTime

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    private val _loginState = MutableStateFlow<Result<LoginData>?>(null)
    val loginState: StateFlow<Result<LoginData>?> = _loginState


    fun onEmailChange(value: String) {
        uiState = uiState.copy(email = value)
    }

    fun onPasswordChange(value: String) {
        uiState = uiState.copy(password = value)
    }

    @OptIn(ExperimentalTime::class)
    fun login(email: String, password: String) {
        uiState.isLoading = true
        viewModelScope.launch {
            try {
                val request = LoginRequest(
                    email = email.trimEnd(),
                    password = password,
                    utcTime = getUtcTimeISO(),
                    deviceId = "9f2a1c33-android"
                )

                val response = repository.login(request)

                uiState.isLoading = false
                if (response.statusCode == 200) {
                    _loginState.value = Result.success(response.data)
                } else {
                    _loginState.value = Result.failure(Exception(response.message))
                }

            } catch (e: Exception) {
                uiState.isLoading = false
                _loginState.value = Result.failure(e)
            }
        }
    }
}