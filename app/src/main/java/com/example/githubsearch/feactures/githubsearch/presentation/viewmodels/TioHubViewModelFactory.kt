package com.example.githubsearch.feactures.githubsearch.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubsearch.feactures.githubsearch.domain.usecases.GetReposUseCase

class TioHubViewModelFactory(
    private val getReposUseCase: GetReposUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TioHubViewModel::class.java)) {
            return TioHubViewModel(getReposUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}