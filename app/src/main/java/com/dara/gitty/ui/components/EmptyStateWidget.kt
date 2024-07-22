package com.dara.gitty.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.dara.gitty.R
import com.dara.gitty.ui.theme.Dimens.PaddingDouble
import com.dara.gitty.ui.theme.Dimens.PaddingExtraLarge

@Composable
fun EmptyStateWidget(
    title: String,
    @DrawableRes image: Int = R.drawable.ic_search_empty,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingExtraLarge),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(id = R.string.search)
        )
        Spacer(modifier = Modifier.height(PaddingDouble))
        Text(text = title, textAlign = TextAlign.Center)
    }
}
