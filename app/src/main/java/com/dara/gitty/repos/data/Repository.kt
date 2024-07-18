package com.dara.gitty.repos.data

data class Repository(
    val owner: String,
    val name: String,
    val imageUrl: String,
    val description: String?,
    val stars: Int,
    val language: String?,
    val topics: List<String>,
    val visibility:String,
    val updatedAt: String,
)
