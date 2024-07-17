package com.dara.users.data

import com.dara.users.data.model.User
import com.dara.users.data.model.UserApiModel

fun UserApiModel.toUser() = User(
    name = login,
    id = id,
    avatarUrl = avatarUrl
)
