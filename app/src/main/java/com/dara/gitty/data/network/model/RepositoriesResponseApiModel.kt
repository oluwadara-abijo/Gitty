package com.dara.gitty.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepositoriesResponseApiModel(
    @SerialName("incomplete_results") val incompleteResults: Boolean,
    @SerialName("items") val repositories: List<RepositoryApiModel>,
    @SerialName("total_count") val totalCount: Int
)
