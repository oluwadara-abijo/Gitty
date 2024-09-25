package com.dara.gitty.users

import com.dara.gitty.data.network.SearchApi
import com.dara.gitty.users.data.UsersRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class UsersRepositoryTest {

    @RelaxedMockK
    private lateinit var mockApi: SearchApi
    private lateinit var underTest: UsersRepository

    @BeforeEach
    fun setUp() {
        underTest = UsersRepository(mockApi)
    }

    @Test
    fun `given server returns list of users, when searching users, then all users are returned`() =
        runTest {
            // Given
            coEvery { mockApi.searchUsers(any()) } returns fakeUsersResponse
            val expectedUsers = fakeUsersResponse.users

            // When
            val result = underTest.searchUsers("")

            // Then
            with(result) {
                assert(isSuccess)
                assert(getOrNull()?.size == expectedUsers.size)
            }
        }

    @Test
    fun `given server returns empty users list, when searching users, then empty list is returned`() =
        runTest {
            // Given
            coEvery { mockApi.searchUsers(any()) } returns fakeEmptyUsersResponse

            // When
            val result = underTest.searchUsers("")

            // Then
            with(result) {
                assert(isSuccess)
                assert(getOrNull()?.size == 0)
            }
        }

    @Test
    fun `given server returns error, when searching users, then error is returned`() =
        runTest {
            // Given
            coEvery { mockApi.searchUsers(any()) } throws Exception()

            // When
            val result = underTest.searchUsers("")

            // Then
            assert(result.isFailure)
            assert(result.exceptionOrNull() is Exception)
        }

    @Test
    fun `given a valid user url, when getUserInfo is called, then it should return success with valid user info`() =
        runTest {
            // Given
            val expectedUserInfo = userInfoApiModels[0]
            coEvery { mockApi.fetchUserInfo(any()) } returns expectedUserInfo

            // When
            val result = underTest.getUserInfo("")

            // Then
            coVerify { mockApi.fetchUserInfo("") }
            with(result) {
                val userInfo = result.getOrNull()
                assert(isSuccess)
                assert(userInfo != null)
                assert(userInfo!!.reposUrl == expectedUserInfo.reposUrl)
                assert(userInfo.username == expectedUserInfo.login)
                assert(userInfo.fullName == expectedUserInfo.name)
            }
        }

    @Test
    fun `given an error occurs, when getUserInfo is called, then error is returned`() =
        runTest {
            // Given
            coEvery { mockApi.fetchUserInfo(any()) } throws Exception()

            // When
            val result = underTest.getUserInfo("")

            // Then
            assert(result.isFailure)
            assert(result.exceptionOrNull() is Exception)
        }

    @Test
    fun `given a valid user url, when getting user's repos, then it should return success with user's repos`() =
        runTest {
            // Given
            coEvery { mockApi.fetchUserRepos(any()) } returns fakeUserRepos

            // When
            val result = underTest.getUserRepos("")

            // Then
            coVerify { mockApi.fetchUserRepos("") }
            with(result) {
                val repo = result.getOrNull()!![0]
                assert(isSuccess)
                assert(repo.name == fakeUserRepos[0].name)
                assert(repo.owner == fakeUserRepos[0].owner.login)

            }
        }

    @Test
    fun `given server returns no user repos, when fetching user repos, then empty list is returned`() =
        runTest {
            // Given
            coEvery { mockApi.fetchUserRepos(any()) } returns emptyList()

            // When
            val result = underTest.getUserRepos("")

            // Then
            with(result) {
                assert(isSuccess)
                assert(getOrNull()?.size == 0)
            }
        }

    @Test
    fun `given an error occurs, when getUserRepos is called, then error is returned`() =
        runTest {
            // Given
            coEvery { mockApi.fetchUserRepos(any()) } throws Exception()

            // When
            val result = underTest.getUserRepos("")

            // Then
            assert(result.isFailure)
            assert(result.exceptionOrNull() is Exception)
        }
}
