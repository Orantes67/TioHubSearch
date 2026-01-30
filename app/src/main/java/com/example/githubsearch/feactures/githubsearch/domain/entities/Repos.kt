package com.example.githubsearch.feactures.githubsearch.domain.entities

data class Repos(
    val id: Int,
    val name: String,
    val fullName: String,
    val description: String?,
    val htmlUrl: String,
    val stargazersCount: Int,
    val forksCount: Int,
    val language: String?,
    val owner: Owner
)

data class Owner(
    val login: String,
    val avatarUrl: String
)