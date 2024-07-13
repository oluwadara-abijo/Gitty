package com.dara.gitty.repos.data

data class Repository(
    val name: String,
    val imageUrl: String,
    val description: String?,
    val stars: Int,
    val language: String?,
)
