package com.dara.gitty.repos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.dara.gitty.R
import com.dara.gitty.ui.components.SearchBar
import com.dara.gitty.ui.theme.Dimens
import com.dara.gitty.ui.theme.Dimens.PaddingDefault
import com.dara.gitty.ui.theme.manropeFamily
import kotlinx.coroutines.launch

@Composable
fun RepositoriesScreen() {
    ReposScreenContent(
        viewModel = hiltViewModel(),
    )
}

@Composable
fun ReposScreenContent(
    viewModel: ReposViewModel,
) {
    val uiState by viewModel.uiState
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

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
            .padding(horizontal = Dimens.PaddingLarge, vertical = Dimens.PaddingExtraLarge)
    ) {

        Text(
            text = stringResource(id = R.string.repositories),
            fontFamily = manropeFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.TextSizeTitle
        )

        SearchBar(
            hint = stringResource(R.string.search_for_repositories),
            onSearchClicked = { searchInput -> viewModel.searchRepos(searchInput) }
        )

        Spacer(modifier = Modifier.height(PaddingDefault))
        LazyColumn {
            items(uiState.repos) { item ->
                RepositoryCard(repository = item)
            }
        }
    }

}