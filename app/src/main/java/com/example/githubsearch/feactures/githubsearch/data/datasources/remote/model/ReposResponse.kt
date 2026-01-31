package com.example.githubsearch.feactures.githubsearch.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

data class ReposResponse(
    @SerializedName("items")
    val items: List<RepositoryDto>
)

data class RepositoryDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("language")
    val language: String?,
    @SerializedName("owner")
    val owner: OwnerDto
)

data class OwnerDto(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
)
