package com.example.githubsearch.feactures.githubsearch.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

data class ReposResponse(
    @SerializedName("items")
    val items: List<TioHubDto>
)