package com.dara.gitty.users

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dara.gitty.data.network.utils.ErrorHandler
import com.dara.gitty.users.data.UsersRepository
import com.dara.gitty.users.ui.UsersViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
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
class UsersViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()
    private val repository: UsersRepository = mockk()
    private val errorHandler: ErrorHandler = mockk()

    private lateinit var viewModel: UsersViewModel

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        // Instantiate the view model
        viewModel = UsersViewModel(repository, errorHandler)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `given repository call succeeds, ui state updates with users`() = runTest {
        // Given
        coEvery { repository.searchUsers(any()) } returns Result.success(fakeUsers)

        // When
        viewModel.searchUsers("John")

        // Then
        assertEquals(viewModel.uiState.value.users, fakeUsers)
        assertEquals(viewModel.uiState.value.isLoading, false)
        assertEquals(viewModel.uiState.value.isNoResult, false)
    }

    @Test
    fun `given empty users list is returned, ui state updates with isNoResult true`() = runTest {
        // Given
        coEvery { repository.searchUsers(any()) } returns Result.success(emptyList())

        // When
        viewModel.searchUsers("John")

        // Then
        assert(viewModel.uiState.value.isNoResult)
        assertEquals(viewModel.uiState.value.isLoading, false)
    }

    @Test
    fun `given repository call fails, ui state updates with error message`() = runTest {
        // Given
        val exception = Exception("Network Error")
        val errorMessage = "An error occurred"
        coEvery { repository.searchUsers(any()) } returns Result.failure(exception)
        every { errorHandler.getErrorMessage(exception) } returns errorMessage

        // When
        viewModel.searchUsers("John")

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