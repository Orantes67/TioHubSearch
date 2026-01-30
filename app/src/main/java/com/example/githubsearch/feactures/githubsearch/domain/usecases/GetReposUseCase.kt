package com.example.githubsearch.feactures.githubsearch.domain.usecases

import com.example.githubsearch.feactures.githubsearch.domain.entities.Repos
import com.example.githubsearch.feactures.githubsearch.domain.repositories.ReposRepository

class GetReposUseCase(private val reposRepository: ReposRepository) {
    suspend operator fun invoke(query: String): List<Repos> {
        return reposRepository.searchRepositories(query)
    }
}
