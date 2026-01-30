package com.example.githubsearch.feactures.githubsearch.data.datasources.remote.mapper

import com.example.githubsearch.feactures.githubsearch.data.datasources.remote.model.RepoItem
import com.example.githubsearch.feactures.githubsearch.domain.entities.Repos
import com.example.githubsearch.feactures.githubsearch.domain.entities.Owner

class ReposMapper {
    fun mapToDomain(repoItem: RepoItem): Repos {
        return Repos(
            id = repoItem.id,
            name = repoItem.name,
            fullName = repoItem.fullName,
            description = repoItem.description ?: "",
            url = repoItem.htmlUrl,
            htmlUrl = repoItem.htmlUrl,
            stars = repoItem.stargazersCount,
            stargazersCount = repoItem.stargazersCount,
            forksCount = repoItem.forksCount,
            language = repoItem.language ?: "N/A",
            owner = Owner(
                login = repoItem.owner.login,
                avatarUrl = repoItem.owner.avatarUrl
            )
        )
    }
}