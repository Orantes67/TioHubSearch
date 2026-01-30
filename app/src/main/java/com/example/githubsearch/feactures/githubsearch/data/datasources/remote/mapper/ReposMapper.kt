package com.example.githubsearch.feactures.githubsearch.data.datasources.remote.mapper
import com.example.githubsearch.feactures.githubsearch.domain.entities.Repos
import com.example.githubsearch.feactures.githubsearch.data.datasources.remote.model.Owner as OwnerDto
import com.example.githubsearch.feactures.githubsearch.data.datasources.remote.model.RepositoryItem as RepositoryItemDto

fun RepositoryItemDto.toDomain(): Repos {
    return Repos(
        id = this.id,
        name = this.name,
        fullName = this.fullName,
        owner = this.owner.toDomain(),
        htmlUrl = this.htmlUrl,
        description = this.description ?: "Sin descripción",
        stargazersCount = this.stargazersCount,
        language = this.language ?: "N/A",
        forksCount = this.forksCount,
        updatedAt = this.updatedAt
    )
}

fun OwnerDto.toDomain(): Owners {
    return Owners(
        login = this.login,
        avatarUrl = this.avatarUrl
    )
}