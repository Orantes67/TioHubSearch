package com.example.githubsearch.feactures.githubsearch.domain.entities



data class Repos(
    val id: Long,
    val name: String,
    val fullName: String,
    val owner: Owners,
    val htmlUrl: String,
    val description: String,
    val stargazersCount: Int,
    val language: String,
    val forksCount: Int,
    val updatedAt: String
)

data class Owners(
    val login: String,
    val avatarUrl: String
)