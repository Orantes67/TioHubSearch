package com.example.githubsearch.feactures.githubsearch.data.repositories

import com.example.githubsearch.core.network.GithubApi
import com.example.githubsearch.feactures.githubsearch.data.datasources.remote.mapper.toDomain
import com.example.githubsearch.feactures.githubsearch.domain.entities.Repos

interface ReposRepository {
    suspend fun searchRepositories(query: String): Result<List<Repos>>
}

class ReposRepositoryImpl(
    private val api: GithubApi
) : ReposRepository {

    override suspend fun searchRepositories(query: String): Result<List<Repos>> {
        return try {
            val response = api.searchRepositories(query)
            val repos = response.items.map { it.toDomain() }
            Result.success(repos)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}