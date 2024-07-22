package com.dara.users.data.model

data class UserInfo(
    val avatarUrl: String,
    val fullName: String,
    val username: String,
    val bio: String,
    val location: String,
    val blog: String,
    val followers: Int,
    val following: Int,
    val reposCount:String,
    val reposUrl: String
)
