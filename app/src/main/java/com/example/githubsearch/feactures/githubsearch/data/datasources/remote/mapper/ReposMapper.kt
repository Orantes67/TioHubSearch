package com.example.githubsearch.feactures.githubsearch.data.datasources.remote.mapper

import com.example.githubsearch.feactures.githubsearch.data.datasources.remote.model.RepositoryDto
import com.example.githubsearch.feactures.githubsearch.domain.entities.Repos
import com.example.githubsearch.feactures.githubsearch.domain.entities.Owner

class ReposMapper {
    fun mapToDomain(repositoryDto: RepositoryDto): Repos {
        return Repos(
            id = repositoryDto.id,
            name = repositoryDto.name,
            fullName = repositoryDto.fullName,
            description = repositoryDto.description ?: "",
            htmlUrl = repositoryDto.htmlUrl,
            stargazersCount = repositoryDto.stargazersCount,
            forksCount = repositoryDto.forksCount,
            language = repositoryDto.language ?: "N/A",
            owner = Owner(
                login = repositoryDto.owner.login,
                avatarUrl = repositoryDto.owner.avatarUrl
            )
        )
    }
}