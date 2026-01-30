package com.example.githubsearch.feactures.githubsearch.domain.repositories

import com.example.githubsearch.feactures.githubsearch.domain.entities.Repos

interface ReposRepository {
    suspend fun searchRepositories(query: String): List<Repos>
}
