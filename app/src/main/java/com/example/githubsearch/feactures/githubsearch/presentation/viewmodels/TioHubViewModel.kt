package com.example.githubsearch.feactures.githubsearch.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubsearch.feactures.githubsearch.domain.entities.Repos
import com.example.githubsearch.feactures.githubsearch.domain.usecases.GetReposUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TioHubViewModel(
    private val getReposUseCase: GetReposUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ReposUiState>(ReposUiState.Initial)
    val uiState: StateFlow<ReposUiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow("all")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()

    // Categorías predefinidas con queries optimizadas para GitHub
    val categories = listOf(
        Category("all", "Todos", ""),
        Category("cybersecurity", "Ciberseguridad", "cybersecurity OR security OR penetration-testing OR hacking"),
        Category("programming", "Programación", "programming OR coding OR development"),
        Category("web", "Desarrollo Web", "web-development OR frontend OR backend OR fullstack"),
        Category("mobile", "Desarrollo Móvil", "android OR ios OR mobile OR kotlin OR swift"),
        Category("ai", "Inteligencia Artificial", "artificial-intelligence OR machine-learning OR deep-learning OR AI"),
        Category("devops", "DevOps", "devops OR docker OR kubernetes OR CI/CD"),
        Category("data", "Ciencia de Datos", "data-science OR data-analysis OR analytics")
    )

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun onCategorySelected(categoryId: String) {
        _selectedCategory.value = categoryId
        searchRepositories()
    }

    fun searchRepositories() {
        viewModelScope.launch {
            _uiState.value = ReposUiState.Loading

            val category = categories.find { it.id == _selectedCategory.value }
            val categoryQuery = category?.query ?: ""

            val result = getReposUseCase(_searchQuery.value, categoryQuery)

            _uiState.value = result.fold(
                onSuccess = { repos ->
                    if (repos.isEmpty()) {
                        ReposUiState.Empty
                    } else {
                        ReposUiState.Success(repos)
                    }
                },
                onFailure = { error ->
                    ReposUiState.Error(error.message ?: "Error desconocido")
                }
            )
        }
    }

    fun clearSearch() {
        _searchQuery.value = ""
        _selectedCategory.value = "all"
        _uiState.value = ReposUiState.Initial
    }
}

sealed class ReposUiState {
    data object Initial : ReposUiState()
    data object Loading : ReposUiState()
    data class Success(val repos: List<Repos>) : ReposUiState()
    data object Empty : ReposUiState()
    data class Error(val message: String) : ReposUiState()
}

data class Category(
    val id: String,
    val name: String,
    val query: String
)