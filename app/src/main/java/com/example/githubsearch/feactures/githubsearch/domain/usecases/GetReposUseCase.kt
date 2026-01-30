package com.example.githubsearch.feactures.githubsearch.domain.usecases

import com.example.githubsearch.feactures.githubsearch.data.repositories.ReposRepository
import com.example.githubsearch.feactures.githubsearch.domain.entities.Repos
import javax.inject.Inject

class GetReposUseCase @Inject constructor(
    private val repository: ReposRepository
) {
    suspend operator fun invoke(searchQuery: String, category: String): Result<List<Repos>> {
        // Construir query combinando búsqueda del usuario con la categoría
        val query = if (searchQuery.isNotEmpty()) {
            "$searchQuery $category"
        } else {
            category
        }

        return repository.searchRepositories(query)
    }
}