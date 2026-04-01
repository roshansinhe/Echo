package com.example.echo.home.viewmodel

import androidx.lifecycle.ViewModel
import com.example.echo.login.datastore.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {
    val firstName = userPreferences.firstNameFlow
}