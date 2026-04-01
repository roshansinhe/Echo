package com.example.echo.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.echo.home.viewmodel.HomeViewModel
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onPlayClick: () -> Unit
) {
    // Collect firstName from ViewModel Flow
    val firstName by viewModel.firstName.collectAsState(initial = null)
    val displayName = firstName ?: "User"

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome Home, $displayName 🎉")
    }
}