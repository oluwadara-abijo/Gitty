package com.dara.gitty.ui.composables

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale.Companion.FillWidth
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import com.dara.gitty.R

@Composable
fun CircleImage(
    url: String,
    size: Dp,
) {
    AsyncImage(
        modifier = Modifier
            .size(size)
            .clip(CircleShape),
        model = url,
        contentDescription = stringResource(R.string.profile_picture),
        contentScale = FillWidth
    )
}
