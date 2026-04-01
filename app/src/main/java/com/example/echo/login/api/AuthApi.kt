package com.example.echo.login.api

import com.example.echo.BuildConfig
import com.example.echo.base.ApiResponse
import com.example.echo.login.model.LoginData
import com.example.echo.login.model.LoginRequest
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {

    @POST("auth/login")
    suspend fun login(
        @Header("apikey") apiKey: String = BuildConfig.API_KEY,
        @Header("apiclient") apiClient: String = "android",
        @Header("device-id") deviceId: String,
        @Header("Authorization") auth: String = "Bearer",
        @Body request: LoginRequest
    ): ApiResponse<LoginData>
}