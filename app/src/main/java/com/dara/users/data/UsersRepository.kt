package com.dara.users.data

import com.dara.gitty.data.network.SearchApi
import com.dara.users.data.model.User
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val searchApi: SearchApi
) {
    suspend fun searchUsers(searchInput: String): Result<List<User>> {
        return try {
            // Get server response
            val serverResponse = searchApi.searchUsers(searchInput)
            // Get list of repositories from server response
            val userApiModels = serverResponse.users
            // Map to UI model
            val users = userApiModels.map { it.toUser() }
            Result.success(users)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
