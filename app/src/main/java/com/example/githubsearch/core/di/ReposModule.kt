package com.example.githubsearch.core.di

import com.example.githubsearch.core.network.GithubApi
import com.example.githubsearch.feactures.githubsearch.data.repositories.ReposRepository
import com.example.githubsearch.feactures.githubsearch.data.repositories.ReposRepositoryImpl
import com.example.githubsearch.feactures.githubsearch.domain.usecases.GetReposUseCase
import com.example.githubsearch.feactures.githubsearch.presentation.viewmodels.TioHubViewModel
import com.example.githubsearch.feactures.githubsearch.presentation.viewmodels.TioHubViewModelFactory

object DependencyContainer {

    // Network
    private val githubApi: GithubApi by lazy {
        NetworkModule.provideGitHubApi()
    }

    // Repository
    private val reposRepository: ReposRepository by lazy {
        ReposRepositoryImpl(githubApi)
    }

    // Use Cases
    private val getReposUseCase: GetReposUseCase by lazy {
        GetReposUseCase(reposRepository)
    }

    // ViewModel Factory
    val tioHubViewModelFactory: TioHubViewModelFactory by lazy {
        TioHubViewModelFactory(getReposUseCase)
    }
}