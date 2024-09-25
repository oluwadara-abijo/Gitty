package com.dara.gitty.repos

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dara.gitty.data.network.utils.ErrorHandler
import com.dara.gitty.repos.data.ReposRepository
import com.dara.gitty.repos.ui.ReposViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Rule
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ReposViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()
    private val repository: ReposRepository = mockk()
    private val errorHandler: ErrorHandler = mockk()

    private lateinit var viewModel: ReposViewModel

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        // Instantiate the view model
        viewModel = ReposViewModel(repository, errorHandler)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `given repository call succeeds, ui state updates with repos`() = runTest {
        // Given
        coEvery { repository.searchRepositories(any()) } returns Result.success(fakeRepos)

        // When
        viewModel.searchRepos("android")

        // Then
        assertEquals(viewModel.uiState.value.repos, fakeRepos)
        assertEquals(viewModel.uiState.value.isLoading, false)
        assertEquals(viewModel.uiState.value.isNoResult, false)
    }

    @Test
    fun `given empty repos list is returned, ui state updates with isNoResult true`() = runTest {
        // Given
        coEvery { repository.searchRepositories(any()) } returns Result.success(emptyList())

        // When
        viewModel.searchRepos("android")

        // Then
        assert(viewModel.uiState.value.isNoResult)
        assertEquals(viewModel.uiState.value.isLoading, false)
    }

    @Test
    fun `given repository call fails, ui state updates with error message`() = runTest {
        // Given
        val exception = Exception("Network Error")
        val errorMessage = "An error occurred"
        coEvery { repository.searchRepositories(any()) } returns Result.failure(exception)
        every { errorHandler.getErrorMessage(exception) } returns errorMessage

        // When
        viewModel.searchRepos("android")

        // Then
        assertEquals(viewModel.uiState.value.errorMessage, errorMessage)
        assertEquals(viewModel.uiState.value.isLoading, false)
    }

    @Test
    fun `given search input changes, ui state updates`(){
        // Given
        val searchInput = "android"

        // When
        viewModel.updateSearchInput(searchInput)

        // Then
        assertEquals(viewModel.uiState.value.searchInput, searchInput)
    }

}