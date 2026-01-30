package com.example.githubsearch.feactures.githubsearch.di

import com.example.githubsearch.core.network.GithubApi
import com.example.githubsearch.feactures.githubsearch.data.datasources.remote.mapper.ReposMapper
import com.example.githubsearch.feactures.githubsearch.data.repositories.ReposRepositoryImpl
import com.example.githubsearch.feactures.githubsearch.domain.repositories.ReposRepository
import com.example.githubsearch.feactures.githubsearch.domain.usecases.GetReposUseCase

object ReposModule {
    fun provideReposMapper(): ReposMapper = ReposMapper()

    fun provideReposRepository(githubApi: GithubApi): ReposRepository {
        return ReposRepositoryImpl(githubApi, provideReposMapper())
    }

    fun provideGetReposUseCase(reposRepository: ReposRepository): GetReposUseCase {
        return GetReposUseCase(reposRepository)
    }
}
