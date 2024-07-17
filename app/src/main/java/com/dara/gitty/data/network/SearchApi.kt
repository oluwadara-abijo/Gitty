package com.dara.gitty.data.network

import com.dara.gitty.repos.data.model.RepositoriesResponseApiModel
import com.dara.users.data.model.UsersResponseApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("repositories")
    suspend fun searchRepositories(@Query("q") searchInput: String): RepositoriesResponseApiModel

    @GET("users")
    suspend fun searchUsers(@Query("q") searchInput: String): UsersResponseApiModel

}
