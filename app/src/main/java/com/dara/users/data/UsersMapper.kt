package com.dara.users.data

import com.dara.users.data.model.User
import com.dara.users.data.model.UserApiModel
import com.dara.users.data.model.UserInfo
import com.dara.users.data.model.UserInfoApiModel

fun UserApiModel.toUser() = User(
    name = login,
    id = id,
    avatarUrl = avatarUrl,
    url = url,
)

fun UserInfoApiModel.toUserInfo() = UserInfo(
    avatarUrl = avatarUrl,
    fullName = name ?: "",
    username = login,
    bio = bio ?: "",
    location = location ?: "",
    blog = blog,
    followers = followers,
    following = following,
    reposCount = publicRepos.toString(),
    reposUrl = reposUrl
)
