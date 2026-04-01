package com.example.echo.base

data class ApiResponse<T>(
    val statusCode: Int,
    val message: String,
    val data: T
)