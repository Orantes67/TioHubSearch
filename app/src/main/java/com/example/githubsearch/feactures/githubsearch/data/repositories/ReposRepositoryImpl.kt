package com.example.githubsearch.feactures.githubsearch.data.repositories

import com.example.githubsearch.core.network.GithubApi
import com.example.githubsearch.feactures.githubsearch.data.datasources.remote.mapper.ReposMapper
import com.example.githubsearch.feactures.githubsearch.domain.entities.Repos
import com.example.githubsearch.feactures.githubsearch.domain.repositories.ReposRepository

class ReposRepositoryImpl(
    private val githubApi: GithubApi,
    private val mapper: ReposMapper
) : ReposRepository {
    override suspend fun searchRepositories(query: String): List<Repos> {
        val response = githubApi.searchRepositories(query)
        return response.items.map { mapper.mapToDomain(it) }
    }
}
