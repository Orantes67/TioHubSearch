package com.example.githubsearch.core.di
import com.example.githubsearch.feactures.githubsearch.data.repositories.ReposRepository
import com.example.githubsearch.feactures.githubsearch.data.repositories.ReposRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

class ReposModule {
    @Module
    @InstallIn(SingletonComponent::class)
    abstract class ReposModule {

        @Binds
        @Singleton
        abstract fun bindReposRepository(
            reposRepositoryImpl: ReposRepositoryImpl
        ): ReposRepository
    }
}