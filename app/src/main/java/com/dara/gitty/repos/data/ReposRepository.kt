package com.dara.gitty.repos.data

import com.dara.gitty.data.network.SearchApi
import com.dara.gitty.repos.toRepository
import javax.inject.Inject

class ReposRepository @Inject constructor(
    private val searchApi: SearchApi
) {
    suspend fun searchRepositories(searchInput: String): Result<List<Repository>> {
        return try {
            // Get server response
            val serverResponse = searchApi.searchRepositories(searchInput)
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
