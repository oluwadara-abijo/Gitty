package com.dara.users.ui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dara.gitty.R
import com.dara.gitty.repos.ui.RepositoryCard
import com.dara.gitty.ui.components.EmptyStateWidget
import com.dara.gitty.ui.components.ProgressBar
import com.dara.gitty.ui.composables.CircleImage
import com.dara.gitty.ui.theme.DarkGreyText
import com.dara.gitty.ui.theme.Dimens.BigAvatar
import com.dara.gitty.ui.theme.Dimens.PaddingDefault
import com.dara.gitty.ui.theme.Dimens.PaddingDouble
import com.dara.gitty.ui.theme.Dimens.PaddingHalf
import com.dara.gitty.ui.theme.Dimens.PaddingLarge
import com.dara.gitty.ui.theme.Dimens.PaddingSmall
import com.dara.gitty.ui.theme.Dimens.TextSizeDefault
import com.dara.gitty.ui.theme.Dimens.TextSizeExtraSmall
import com.dara.gitty.ui.theme.Dimens.TextSizeLarge
import com.dara.gitty.ui.theme.Dimens.TextSizeSmall
import com.dara.gitty.ui.theme.SliderColor
import com.dara.users.ui.UserDetailViewModel
import kotlinx.coroutines.launch

@Composable
fun UserDetailScreen(
    navigateBack: () -> Unit
) {
    UserDetailScreenContent(
        viewModel = hiltViewModel(),
        navigateBack = navigateBack
    )
}

@Composable
fun UserDetailScreenContent(
    viewModel: UserDetailViewModel,
    navigateBack: () -> Unit
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
            Modifier
                .fillMaxSize()
                .background(color = White)
                .padding(paddingValues)
                .padding(vertical = PaddingDouble, horizontal = PaddingLarge)
        ) {
            if (uiState.userInfo != null) {
                val userInfo = uiState.userInfo!!

                Row(verticalAlignment = CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = stringResource(R.string.back),
                        modifier = Modifier.clickable { navigateBack() }
                    )
                    Spacer(modifier = Modifier.width(PaddingLarge))
                    Text(
                        text = stringResource(id = R.string.users),
                        fontWeight = SemiBold,
                        fontSize = TextSizeDefault
                    )
                }
                Spacer(modifier = Modifier.height(PaddingLarge))
                Row {
                    CircleImage(
                        url = userInfo.avatarUrl,
                        size = BigAvatar
                    )
                    Spacer(modifier = Modifier.width(PaddingDefault))
                    Column {
                        if (userInfo.fullName.isNotEmpty()) {
                            Text(
                                text = userInfo.fullName,
                                fontWeight = SemiBold,
                                fontSize = TextSizeLarge
                            )
                        }
                        Text(
                            text = userInfo.username,
                            fontWeight = Normal,
                            fontSize = TextSizeLarge
                        )
                    }
                }
                if (userInfo.bio.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(PaddingLarge))
                    Text(
                        text = userInfo.bio,
                        fontSize = TextSizeSmall
                    )
                }
                Row(
                    verticalAlignment = CenterVertically,
                    modifier = Modifier.padding(top = PaddingLarge)
                ) {
                    if (userInfo.location.isNotEmpty()) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(PaddingSmall))
                        Text(
                            text = userInfo.location,
                            color = DarkGreyText,
                            fontSize = TextSizeExtraSmall
                        )
                    }
                    if (userInfo.blog.isNotEmpty()) {
                        Spacer(modifier = Modifier.width(PaddingDefault))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_link),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(PaddingSmall))
                        Text(
                            text = userInfo.blog,
                            fontSize = TextSizeExtraSmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
                Row(
                    verticalAlignment = CenterVertically,
                    modifier = Modifier.padding(top = PaddingHalf)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_followers),
                        contentDescription = stringResource(R.string.followers)
                    )
                    Spacer(modifier = Modifier.width(PaddingSmall))
                    Text(
                        text = "${userInfo.followers} followers  .",
                        fontSize = TextSizeExtraSmall,
                        color = DarkGreyText
                    )
                    Spacer(modifier = Modifier.width(PaddingHalf))
                    Text(
                        text = "${userInfo.following} following",
                        fontSize = TextSizeExtraSmall,
                        color = DarkGreyText
                    )
                }
                Row(modifier = Modifier.padding(top = PaddingLarge)) {
                    Text(
                        text = stringResource(id = R.string.repositories),
                        fontSize = TextSizeExtraSmall,
                    )
                    Spacer(modifier = Modifier.width(PaddingHalf))
                    Text(
                        text = userInfo.reposCount,
                        fontSize = TextSizeExtraSmall,
                        modifier = Modifier
                            .background(color = SliderColor, shape = CircleShape)
                            .padding(horizontal = PaddingHalf)
                    )
                }
                Spacer(modifier = Modifier.height(PaddingSmall))
                TwoColorLine()
                Spacer(modifier = Modifier.height(PaddingSmall))
                LazyColumn {
                    items(uiState.repos) { item ->
                        RepositoryCard(repository = item, isForUserDetails = true)
                    }
                }
                ProgressBar(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    loading = uiState.isLoading
                )
                if (uiState.hasNoRepos) {
                    EmptyStateWidget(
                        title = stringResource(R.string.no_user_repos),
                        image = R.drawable.empty_repos
                    )
                }
            }
        }
    }
}

@Composable
fun TwoColorLine() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        val width = size.width
        drawLine(
            color = Black,
            start = Offset(0f, size.height / 2),
            end = Offset(width / 3, size.height / 2),
            strokeWidth = size.height
        )
        drawLine(
            color = SliderColor,
            start = Offset(width / 3, size.height / 2),
            end = Offset(width, size.height / 2),
            strokeWidth = size.height
        )
    }
}
