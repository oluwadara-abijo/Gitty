package com.dara.gitty.users.data

import com.dara.gitty.data.network.SearchApi
import com.dara.gitty.repos.data.Repository
import com.dara.gitty.repos.toRepository
import com.dara.gitty.users.data.model.User
import com.dara.gitty.users.data.model.UserInfo
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

    suspend fun getUserInfo(url: String): Result<UserInfo> {
        return try {
            // Get server response
            val apiModel = searchApi.fetchUserInfo(url)
            // Map to UI model
            val userInfo = apiModel.toUserInfo()
            Result.success(userInfo)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUserRepos(url: String): Result<List<Repository>> {
        return try {
            // Get server response
            val apiModel = searchApi.fetchUserRepos(url)
            // Map to UI model
            val userInfo = apiModel.map { it.toRepository() }
            Result.success(userInfo)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
