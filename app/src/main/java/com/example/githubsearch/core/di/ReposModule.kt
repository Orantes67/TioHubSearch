package com.example.githubsearch.core.di

import android.content.Context
import com.example.githubsearch.core.network.GithubApi
import com.example.githubsearch.feactures.githubsearch.data.datasources.remote.mapper.ReposMapper
import com.example.githubsearch.feactures.githubsearch.data.repositories.ReposRepositoryImpl
import com.example.githubsearch.feactures.githubsearch.domain.repositories.ReposRepository
import com.example.githubsearch.feactures.githubsearch.domain.usecases.GetReposUseCase
import com.example.githubsearch.feactures.githubsearch.presentation.viewmodels.TioHubViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object DependencyContainer {

    private const val GITHUB_API_BASE_URL = "https://api.github.com/"

    // Network
    fun createRetrofit(context: Context): Retrofit {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        return Retrofit.Builder()
            .baseUrl(GITHUB_API_BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private lateinit var retrofit: Retrofit

    fun initialize(context: Context) {
        retrofit = createRetrofit(context)
    }

    private val githubApi: GithubApi by lazy {
        retrofit.create(GithubApi::class.java)
    }

    private val reposMapper: ReposMapper by lazy {
        ReposMapper()
    }

    private val reposRepository: ReposRepository by lazy {
        ReposRepositoryImpl(githubApi, reposMapper)
    }

    private val getReposUseCase: GetReposUseCase by lazy {
        GetReposUseCase(reposRepository)
    }

    val tioHubViewModelFactory: TioHubViewModelFactory by lazy {
        TioHubViewModelFactory(getReposUseCase)
    }
}
