package com.example.echo.login.model

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    var isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)