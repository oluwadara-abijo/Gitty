package com.dara.gitty.users

import com.dara.gitty.users.data.toUser
import com.dara.gitty.users.data.toUserInfo
import org.junit.jupiter.api.Test

class UsersMapperTest {

    @Test
    fun `given a UserApiModel, when mapped, then a User object is returned with corresponding parameters`(){
        // Given
        val userApiModel = userApiModels[0]

        // When
        val user = userApiModel.toUser()

        // Then
        with(user) {
            assert(name == userApiModel.login)
            assert(id == userApiModel.id)
            assert(avatarUrl == userApiModel.avatarUrl)
            assert(url == userApiModel.url)
        }
    }

    @Test
    fun `given a UserInfoApiModel, when mapped, then a UserInfo object is returned with corresponding parameters`() {
        // Given
        val userInfoApiModel = userInfoApiModels[0]

        // When
        val userInfo = userInfoApiModel.toUserInfo()

        // Then
        with(userInfo) {
            assert(avatarUrl == userInfoApiModel.avatarUrl)
            assert(fullName == userInfoApiModel.name)
            assert(username == userInfoApiModel.login)
            assert(bio == userInfoApiModel.bio)
            assert(location == userInfoApiModel.location)
            assert(blog == userInfoApiModel.blog)
            assert(followers == userInfoApiModel.followers)
            assert(following == userInfoApiModel.following)
            assert(reposCount == userInfoApiModel.publicRepos.toString())
            assert(reposUrl == userInfoApiModel.reposUrl)
        }
    }
}