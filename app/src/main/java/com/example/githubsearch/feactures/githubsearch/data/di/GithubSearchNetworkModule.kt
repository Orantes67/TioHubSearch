package com.example.githubsearch.feactures.githubsearch.data.di


import com.example.githubsearch.core.di.GithubSearchRetrofit
import com.example.githubsearch.feactures.githubsearch.data.datasources.remote.api.GitHubSearchApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GithubSearchNetworkModule {
    @Provides
    @Singleton
    fun GitHubSearchApi(@GithubSearchRetrofit retrofit: Retrofit): GitHubSearchApi {
        return retrofit.create(GitHubSearchApi::class.java)
    }
}