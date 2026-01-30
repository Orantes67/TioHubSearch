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
import java.util.Properties
import java.io.FileInputStream
import java.io.File

object DependencyContainer {

    private fun getLocalProperty(key: String, context: Context): String {
        return try {
            val properties = Properties()
            val localPropertiesFile = File(context.filesDir.parentFile?.parentFile?.parentFile, "local.properties")
            if (localPropertiesFile.exists()) {
                properties.load(FileInputStream(localPropertiesFile))
                properties.getProperty(key, "https://api.github.com/")
            } else {
                "https://api.github.com/"
            }
        } catch (e: Exception) {
            "https://api.github.com/"
        }
    }

    // Network
    fun createRetrofit(context: Context): Retrofit {
        val baseUrl = getLocalProperty("BASE_URL", context)
        return Retrofit.Builder()
            .baseUrl(baseUrl)
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
