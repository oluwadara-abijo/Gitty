package com.dara.gitty.data.network

import com.dara.gitty.repos.data.model.RepositoriesResponseApiModel
import com.dara.gitty.repos.data.model.RepositoryApiModel
import com.dara.gitty.users.data.model.UserInfoApiModel
import com.dara.gitty.users.data.model.UsersResponseApiModel
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface SearchApi {

    @GET("repositories")
    suspend fun searchRepositories(@Query("q") searchInput: String): RepositoriesResponseApiModel

    @GET("users")
    suspend fun searchUsers(@Query("q") searchInput: String): UsersResponseApiModel

    @GET
    suspend fun fetchUserInfo(@Url url: String) : UserInfoApiModel

    @GET
    suspend fun fetchUserRepos(@Url url: String) : List<RepositoryApiModel>

}
