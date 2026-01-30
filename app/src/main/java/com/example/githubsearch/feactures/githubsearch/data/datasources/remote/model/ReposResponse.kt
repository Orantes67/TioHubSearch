package com.example.githubsearch.feactures.githubsearch.data.datasources.remote.model
import com.google.gson.annotations.SerializedName

data class ReposResponse(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<RepositoryItem>
)

data class RepositoryItem(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("language")
    val language: String?,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("updated_at")
    val updatedAt: String
)

data class Owner(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
)
