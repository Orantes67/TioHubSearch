package com.example.githubsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.githubsearch.core.di.DependencyContainer
import com.example.githubsearch.core.ui.theme.AppTheme
import com.example.githubsearch.feactures.githubsearch.presentation.screens.TioHubScreen
import com.example.githubsearch.feactures.githubsearch.presentation.viewmodels.TioHubViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DependencyContainer.initialize(this)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    val tioHubViewModel: TioHubViewModel = viewModel(factory = DependencyContainer.tioHubViewModelFactory)
                    TioHubScreen(
                        viewModel = tioHubViewModel,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}