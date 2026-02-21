package com.example.githubsearch.feactures.githubsearch.data.di

import com.example.githubsearch.feactures.githubsearch.data.repositories.ReposRepositoryImpl
import com.example.githubsearch.feactures.githubsearch.domain.repositories.ReposRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindReposRepository(
        reposRepositoryImpl: ReposRepositoryImpl
    ): ReposRepository
}