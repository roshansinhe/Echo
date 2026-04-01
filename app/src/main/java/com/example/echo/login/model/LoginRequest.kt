package com.example.echo.login.model

data class LoginRequest(
    val email: String,
    val password: String,
    val utcTime: String,
    val deviceId: String
)