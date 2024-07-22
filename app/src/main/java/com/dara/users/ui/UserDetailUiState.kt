package com.dara.users.ui

import com.dara.gitty.repos.data.Repository
import com.dara.users.data.model.UserInfo

data class UserDetailUiState(
    val userInfo: UserInfo? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val repos : List<Repository> = emptyList(),
    val hasNoRepos: Boolean = false,
)
