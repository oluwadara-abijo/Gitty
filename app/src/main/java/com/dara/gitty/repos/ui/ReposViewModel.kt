package com.dara.gitty.repos.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dara.gitty.data.network.utils.ErrorHandler
import com.dara.gitty.repos.data.ReposRepository
import com.dara.gitty.repos.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(
    private val repository: ReposRepository,
    private val errorHandler: ErrorHandler,
) : ViewModel() {

    private val _uiState = mutableStateOf(ReposUiState())
    val uiState: State<ReposUiState> = _uiState

    fun searchRepos(searchInput: String) {
        updateState(isEmptyState = false, isLoading = true)

        viewModelScope.launch {
            val result = repository.searchRepositories(searchInput)
            result.fold(
                onSuccess = { repos ->
                    updateState(isLoading = false)
                    if (repos.isEmpty()) {
                        updateState(isNoResult = true)
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

    // Updates the current state of the UI
    private fun updateState(
        repos: List<Repository>? = null,
        isEmptyState: Boolean? = null,
        isNoResult: Boolean? = null,
        isLoading: Boolean? = null,
        errorMessage: String? = null
    ) {
        _uiState.value = _uiState.value.copy(
            repos = repos ?: _uiState.value.repos,
            isEmptyState = isEmptyState ?: _uiState.value.isEmptyState,
            isNoResult = isNoResult ?: _uiState.value.isNoResult,
            isLoading = isLoading ?: _uiState.value.isLoading,
            errorMessage = errorMessage ?: _uiState.value.errorMessage
        )
    }
}