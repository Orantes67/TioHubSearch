package com.example.githubsearch.feactures.githubsearch.domain.usecases

import com.example.githubsearch.feactures.githubsearch.domain.entities.Repos
import com.example.githubsearch.feactures.githubsearch.domain.repositories.ReposRepository

class GetReposUseCase(private val reposRepository: ReposRepository) {
    suspend operator fun invoke(
        query: String,
        categoryQuery: String = ""
    ): Result<List<Repos>> {
        return try {
            // Construir la query final
            val finalQuery = buildFinalQuery(query, categoryQuery)
            
            if (finalQuery.isEmpty()) {
                return Result.failure(Exception("La búsqueda no puede estar vacía"))
            }
            
            val repos = reposRepository.searchRepositories(finalQuery)
            Result.success(repos)
        } catch (e: Exception) {
            android.util.Log.e("GetReposUseCase", "Error en búsqueda: ${e.message}", e)
            Result.failure(e)
        }
    }

    private fun buildFinalQuery(query: String, categoryQuery: String): String {
        val searchQuery = query.trim()
        val category = categoryQuery.trim()
        
        return when {
            searchQuery.isNotEmpty() && category.isNotEmpty() -> {
                "$searchQuery $category"
            }
            searchQuery.isNotEmpty() -> {
                searchQuery
            }
            category.isNotEmpty() -> {
                category
            }
            else -> {
                // Fallback si no hay búsqueda ni categoría
                "android"
            }
        }
    }
}
