package com.dara.gitty.repos.ui

import com.dara.gitty.repos.data.Repository

data class ReposUiState(
    val repos: List<Repository> = emptyList(),
    val isEmptyState: Boolean = true,
    val isNoResult: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
