package com.example.echo.login.model

data class LoginData(
    val personId: Int,
    val token: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val height: Double,
    val weight: Double,
    val gender: IdName,
    val religion: IdName,
    val activityLevel: IdName,
    val stressLevel: IdName,
    val sleepQuality: IdName,
    val dob: String,
    val timeToSleep: String,
    val weaknesses: List<Weakness>,
    val isVerified: Boolean,
    val refreshToken: String,
    val progressData: ProgressData
)

data class IdName(
    val id: Int,
    val name: String
)

data class Weakness(
    val categoryId: Int,
    val categoryName: String,
    val values: List<String>
)

data class ProgressData(
    val id: Int,
    val personId: Int,
    val date: String,
    val water: Double,
    val calories: Double,
    val exerciseMinutes: Int,
    val sleepHours: Double,
    val meditationMinutes: Int,
    val waterTarget: Double,
    val calorieTarget: Double,
    val exerciseTarget: Int,
    val sleepTarget: Double,
    val meditationTarget: Int,
    val nutritionScore: Int,
    val hydrationScore: Int,
    val exerciseScore: Int,
    val meditationScore: Int,
    val sleepScore: Int,
    val totalScore: Int,
    val totalExpectedScore: Int,
    val programInfo: Any?
)