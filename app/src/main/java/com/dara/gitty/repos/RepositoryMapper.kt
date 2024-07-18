package com.dara.gitty.repos

import com.dara.gitty.repos.data.model.RepositoryApiModel
import com.dara.gitty.repos.data.Repository

fun RepositoryApiModel.toRepository()  = Repository(
    owner = owner.login,
    name = name,
    imageUrl = owner.avatarUrl,
    description = description,
    stars = stargazersCount,
    language = language,
    topics = topics,
    visibility = visibility,
    updatedAt = updatedAt,
)
