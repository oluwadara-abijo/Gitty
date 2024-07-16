package com.dara.gitty.repos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dara.gitty.R
import com.dara.gitty.repos.data.Repository
import com.dara.gitty.ui.theme.BlueBg
import com.dara.gitty.ui.theme.BlueText
import com.dara.gitty.ui.theme.Dimens.PaddingDefault
import com.dara.gitty.ui.theme.Dimens.PaddingHalf
import com.dara.gitty.ui.theme.Dimens.PaddingLarge
import com.dara.gitty.ui.theme.Dimens.PaddingSmall
import com.dara.gitty.ui.theme.PurpleText

@Composable
fun RepositoryCard(repository: Repository) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = PaddingHalf),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(PaddingSmall),
        colors = CardDefaults.cardColors(containerColor = White),
    ) {
        RowContent {
            AsyncImage(
                modifier = Modifier
                    .size(PaddingLarge)
                    .clip(CircleShape),
                model = repository.imageUrl,
                contentDescription = repository.name,
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = "${repository.owner}/",
                modifier = Modifier.padding(start = PaddingHalf),
                color = PurpleText,
                fontWeight = Normal
            )
            Text(text = repository.name, color = Black, fontWeight = SemiBold, maxLines = 1)
        }

        RowContent {
            Icon(painter = painterResource(id = R.drawable.ic_star), contentDescription = "Stars")
            Text(
                text = repository.stars.toString(),
                color = Black,
                fontWeight = Normal,
                modifier = Modifier.padding(start = PaddingSmall)
            )
            Spacer(modifier = Modifier.width(PaddingHalf))
            Image(
                painter = painterResource(id = R.drawable.ic_lang),
                contentDescription = "Language"
            )
            Text(
                text = repository.language.toString(),
                color = Black,
                fontWeight = Normal,
                modifier = Modifier.padding(start = PaddingSmall)
            )
        }

        Text(
            modifier = Modifier.padding(top = PaddingLarge, start = PaddingHalf, end = PaddingHalf),
            text = repository.description.toString(),
            color = Black,
            fontWeight = Normal,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(PaddingHalf))

        RowContent {
            for (topic in repository.topics.take(2)) {
                Text(
                    modifier = Modifier
                        .padding(end = PaddingHalf, bottom = PaddingDefault)
                        .background(color = BlueBg, shape = RoundedCornerShape(6.dp))
                        .padding(vertical = PaddingSmall, horizontal = PaddingHalf),
                    text = topic,
                    color = BlueText,
                    fontWeight = Normal,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }


    }
}

@Composable
fun RowContent(
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier.padding(top = PaddingHalf, start = PaddingHalf),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        content()
    }
}
