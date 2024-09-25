package com.dara.gitty.users.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dara.gitty.data.network.utils.ErrorHandler
import com.dara.gitty.repos.data.Repository
import com.dara.gitty.users.data.UsersRepository
import com.dara.gitty.users.data.model.UserInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val repository: UsersRepository,
    private val errorHandler: ErrorHandler,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val username: String = checkNotNull(savedStateHandle["name"])
    private val _uiState = mutableStateOf(UserDetailUiState())
    val uiState: State<UserDetailUiState> = _uiState

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        updateState(isLoading = true)
        viewModelScope.launch {
            val userInfoResult = repository.getUserInfo(buildUrl(username))
            userInfoResult.fold(
                onSuccess = { userInfo ->
                    updateState(
                        isLoading = false,
                        userInfo = userInfo
                    )
                    getUserRepos()
                },
                onFailure = { exception ->
                    updateState(
                        isLoading = false,
                        errorMessage = errorHandler.getErrorMessage(exception)
                    )
                })
        }
    }

    private fun getUserRepos() {
        if (uiState.value.userInfo != null) {
            updateState(isLoading = true)
            viewModelScope.launch {
                val result = repository.getUserRepos(uiState.value.userInfo!!.reposUrl)
                result.fold(
                    onSuccess = { repos ->
                        updateState(isLoading = false)
                        if (repos.isEmpty()) {
                            updateState(hasNoRepos = true)
                        } else {
                            updateState(repos = repos)
                        }
                    },
                    onFailure = { exception ->
                        updateState(
                            isLoading = false,
                            errorMessage = errorHandler.getErrorMessage(exception)
                        )
                    })
            }
        }
    }

    // Updates the current state of the UI
    private fun updateState(
        userInfo: UserInfo? = null,
        isLoading: Boolean? = null,
        errorMessage: String? = null,
        repos: List<Repository>? = null,
        hasNoRepos: Boolean? = null
    ) {
        _uiState.value = _uiState.value.copy(
            userInfo = userInfo ?: _uiState.value.userInfo,
            isLoading = isLoading ?: _uiState.value.isLoading,
            errorMessage = errorMessage ?: _uiState.value.errorMessage,
            repos = repos ?: _uiState.value.repos,
            hasNoRepos = hasNoRepos ?: _uiState.value.hasNoRepos
        )
    }

    private fun buildUrl(username: String): String {
        return "https://api.github.com/users/$username"
    }
}
