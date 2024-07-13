package com.dara.gitty.ui.model

data class Repository(
    val name: String,
    val imageUrl: String,
    val description: String?,
    val stars: Int,
    val language: String?,
)
