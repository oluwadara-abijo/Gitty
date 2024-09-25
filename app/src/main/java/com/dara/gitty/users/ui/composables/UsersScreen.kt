package com.dara.gitty.users.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.dara.gitty.R
import com.dara.gitty.ui.components.EmptyStateWidget
import com.dara.gitty.ui.components.ProgressBar
import com.dara.gitty.ui.components.SearchBar
import com.dara.gitty.ui.theme.Dimens
import com.dara.gitty.ui.theme.manropeFamily
import com.dara.gitty.users.ui.UsersViewModel
import kotlinx.coroutines.launch

@Composable
fun UsersScreen(
    navigateToUserDetail: (String) -> Unit
) {
    UsersScreenContent(
        viewModel = hiltViewModel(),
        navigateToUserDetail = navigateToUserDetail
    )
}

@Composable
fun UsersScreenContent(
    viewModel: UsersViewModel,
    navigateToUserDetail: (String) -> Unit
) {
    val uiState by viewModel.uiState
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        if (!uiState.errorMessage.isNullOrEmpty()) {
            LaunchedEffect(key1 = uiState.errorMessage) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(uiState.errorMessage!!)
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(
                    start = Dimens.PaddingLarge,
                    end = Dimens.PaddingLarge,
                    top = Dimens.PaddingExtraLarge
                )
        ) {

            Text(
                text = stringResource(id = R.string.users),
                fontFamily = manropeFamily,
                fontWeight = FontWeight.Bold,
                fontSize = Dimens.TextSizeTitle
            )

            SearchBar(
                hint = stringResource(R.string.search_for_users),
                searchInput = uiState.searchInput,
                onSearchInputChanged = { searchInput -> viewModel.updateSearchInput(searchInput) },
                onSearchClicked = { searchInput -> viewModel.searchUsers(searchInput) }
            )

            Spacer(modifier = Modifier.height(Dimens.PaddingDefault))

            when {
                uiState.isEmptyState ->
                    EmptyStateWidget(title = stringResource(R.string.search_for_users_empty))

                uiState.isNoResult ->
                    EmptyStateWidget(title = stringResource(R.string.search_users_no_result))

                uiState.isLoading ->
                    ProgressBar(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        loading = true
                    )

            }

            LazyColumn {
                items(uiState.users) { item ->
                    UserCard(
                        user = item,
                        navigateToUserDetail = navigateToUserDetail
                    )
                }
            }
        }

    }
}
