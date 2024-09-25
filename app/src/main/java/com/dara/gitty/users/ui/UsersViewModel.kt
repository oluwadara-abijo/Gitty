package com.dara.gitty.users.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dara.gitty.data.network.utils.ErrorHandler
import com.dara.gitty.users.data.UsersRepository
import com.dara.gitty.users.data.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val repository: UsersRepository,
    private val errorHandler: ErrorHandler,
) : ViewModel() {

    private val _uiState = mutableStateOf(UsersUiState())
    val uiState: State<UsersUiState> = _uiState

    fun searchUsers(searchInput: String) {
        updateState(isEmptyState = false, isLoading = true)

        viewModelScope.launch {
            val result = repository.searchUsers(searchInput)
            result.fold(
                onSuccess = { users ->
                    updateState(isLoading = false)
                    if (users.isEmpty()) {
                        updateState(isNoResult = true)
                    } else {
                        updateState(users = users, isNoResult = false)
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

    // Updates the current state of the UI
    private fun updateState(
        users: List<User>? = null,
        isEmptyState: Boolean? = null,
        isNoResult: Boolean? = null,
        isLoading: Boolean? = null,
        errorMessage: String? = null
    ) {
        _uiState.value = _uiState.value.copy(
            users = users ?: _uiState.value.users,
            isEmptyState = isEmptyState ?: _uiState.value.isEmptyState,
            isNoResult = isNoResult ?: _uiState.value.isNoResult,
            isLoading = isLoading ?: _uiState.value.isLoading,
            errorMessage = errorMessage ?: _uiState.value.errorMessage
        )
    }
}