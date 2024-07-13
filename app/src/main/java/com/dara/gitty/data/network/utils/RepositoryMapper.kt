package com.dara.gitty.data.network.utils

import com.dara.gitty.data.network.model.RepositoryApiModel
import com.dara.gitty.ui.model.Repository

fun RepositoryApiModel.toRepository()  = Repository(
    name = fullName,
    imageUrl = owner.avatarUrl,
    description = description,
    stars = stargazersCount,
    language = language,
)
