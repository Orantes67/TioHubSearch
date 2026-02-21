package com.example.githubsearch.feactures.githubsearch.data.datasources.remote.api

import com.example.githubsearch.feactures.githubsearch.data.datasources.remote.model.RepositoryDto
import retrofit2.http.GET


interface GitHubSearchApi {
    @GET("posts")
    suspend fun getPosts(): List<RepositoryDto>
}