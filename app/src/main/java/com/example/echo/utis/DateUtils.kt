package com.example.echo.utis
import java.time.Instant

fun getUtcTimeISO(): String {
    return Instant.now().toString()
}