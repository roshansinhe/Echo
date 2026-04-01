package com.example.echo.login.repository

import com.example.echo.base.ApiResponse
import com.example.echo.login.api.AuthApi
import com.example.echo.login.model.LoginData
import com.example.echo.login.model.LoginRequest
import com.example.echo.login.datastore.UserPreferences
import javax.inject.Inject

open class AuthRepository @Inject constructor(
    private val api: AuthApi,
    private val userPreferences: UserPreferences
) {
    suspend fun login(request: LoginRequest): ApiResponse<LoginData> {
        val response = api.login(
            deviceId = request.deviceId,
            request = request
        )

        // Save personId, token, firstName locally
        if (response.statusCode == 200) {
            val data = response.data
            userPreferences.savePersonId(data.personId)
            userPreferences.saveToken(data.token)
            userPreferences.saveFirstName(data.firstName)
        }

        return response
    }
}