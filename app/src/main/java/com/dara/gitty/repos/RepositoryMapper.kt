package com.dara.gitty.repos

import com.dara.gitty.repos.data.model.RepositoryApiModel
import com.dara.gitty.repos.data.Repository

fun RepositoryApiModel.toRepository()  = Repository(
    name = fullName,
    imageUrl = owner.avatarUrl,
    description = description,
    stars = stargazersCount,
    language = language,
)
