package com.example.echo.login.repository

import com.example.echo.base.ApiResponse
import com.example.echo.login.api.AuthApi
import com.example.echo.login.model.LoginData
import com.example.echo.login.model.LoginRequest
import javax.inject.Inject

open class AuthRepository @Inject constructor(
    private val api: AuthApi
) {
    suspend fun login(request: LoginRequest): ApiResponse<LoginData> {
        return api.login(
            deviceId = request.deviceId,
            request = request
        )
    }
}