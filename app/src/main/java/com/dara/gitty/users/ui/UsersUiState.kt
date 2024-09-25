package com.dara.gitty.users.ui

import com.dara.gitty.users.data.model.User

data class UsersUiState(
    val users: List<User> = emptyList(),
    val isEmptyState: Boolean = true,
    val isNoResult: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
