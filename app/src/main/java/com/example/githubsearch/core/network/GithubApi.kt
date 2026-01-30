package com.example.githubsearch.core.network
import com.example.githubsearch.feactures.githubsearch.data.datasources.remote.model.ReposResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",
        @Query("per_page") perPage: Int = 30
    ): ReposResponse

}