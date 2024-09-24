package com.dara.gitty.repos

import com.dara.gitty.data.network.SearchApi
import com.dara.gitty.repos.data.ReposRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class ReposRepositoryTest {

    @RelaxedMockK
    private lateinit var mockApi: SearchApi
    private lateinit var underTest: ReposRepository

    @BeforeEach
    fun setUp() {
        underTest = ReposRepository(mockApi)
    }

    @Test
    fun `given server returns list of repos, when searching repos, then all repos are returned`() =
        runTest {
            // Given
            coEvery { mockApi.searchRepositories(any()) } returns fakeReposResponse
            val expectedRepos = fakeReposResponse.repositories

            // When
            val repositoryResult = underTest.searchRepositories("")

            // Then
            with(repositoryResult) {
                assert(isSuccess)
                assert(getOrNull()?.size == expectedRepos.size)
            }
        }

    @Test
    fun `given server returns empty repos list, when searching repos, then empty list is returned`() =
        runTest {
            // Given
            coEvery { mockApi.searchRepositories(any()) } returns fakeEmptyReposResponse

            // When
            val repositoryResult = underTest.searchRepositories("")

            // Then
            with(repositoryResult) {
                assert(isSuccess)
                assert(getOrNull()?.size == 0)
            }
        }

    @Test
    fun `given server returns error, when searching repos, then error is returned`() =
        runTest {
            // Given
            coEvery { mockApi.searchRepositories(any()) } throws Exception()

            // When
            val repositoryResult = underTest.searchRepositories("")

            // Then
            assert(repositoryResult.isFailure)
            assert(repositoryResult.exceptionOrNull() is Exception)
        }
}
