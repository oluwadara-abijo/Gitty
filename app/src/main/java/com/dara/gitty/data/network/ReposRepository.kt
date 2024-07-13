package com.dara.gitty.data.network

import com.dara.gitty.data.network.utils.toRepository
import com.dara.gitty.ui.model.Repository
import javax.inject.Inject

class ReposRepository @Inject constructor(
    private val searchApi: SearchApi
) {
    suspend fun searchRepositories(searchQuery: String): Result<List<Repository>> {
        return try {
            // Get server response
            val serverResponse = searchApi.searchRepositories(searchQuery)
            // Get list of repositories from server response
            val repositoryApiModels = serverResponse.repositories
            // Map to UI model
            val repositories = repositoryApiModels.map { it.toRepository() }
            Result.success(repositories)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
