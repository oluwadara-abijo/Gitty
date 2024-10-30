package com.dara.gitty.repos.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dara.gitty.R
import com.dara.gitty.repos.data.Repository
import com.dara.gitty.ui.composables.CircleImage
import com.dara.gitty.ui.theme.BlueBg
import com.dara.gitty.ui.theme.BlueText
import com.dara.gitty.ui.theme.DarkGreyText
import com.dara.gitty.ui.theme.Dimens.PaddingDefault
import com.dara.gitty.ui.theme.Dimens.PaddingHalf
import com.dara.gitty.ui.theme.Dimens.PaddingLarge
import com.dara.gitty.ui.theme.Dimens.PaddingSmall
import com.dara.gitty.ui.theme.Dimens.TextSizeExtraSmall
import com.dara.gitty.ui.theme.Dimens.TextSizeSmall
import com.dara.gitty.ui.theme.GreyBorder
import com.dara.gitty.ui.theme.PurpleText
import com.dara.gitty.utils.toTimeAgo

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RepositoryCard(
    repository: Repository,
    isForUserDetails: Boolean? = false
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = PaddingHalf),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(PaddingSmall),
        colors = CardDefaults.cardColors(containerColor = White),
    ) {
        RowContent {
            Row(Modifier.fillMaxWidth(0.8f)) {
                CircleImage(
                    url = repository.imageUrl,
                    size = PaddingLarge
                )
                Text(
                    text = "${repository.owner}/",
                    modifier = Modifier.padding(start = PaddingHalf),
                    color = PurpleText,
                    fontWeight = Normal,
                    fontSize = TextSizeSmall
                )
                Text(
                    text = repository.name,
                    color = Black,
                    fontWeight = SemiBold,
                    maxLines = 1,
                    fontSize = TextSizeSmall
                )
            }
            if (isForUserDetails == true) {
                Text(
                    text = repository.visibility,
                    fontSize = TextSizeExtraSmall,
                    modifier = Modifier
                        .padding(horizontal = PaddingHalf, vertical = PaddingSmall)
                        .border(BorderStroke(0.5.dp, GreyBorder), RoundedCornerShape(PaddingHalf))
                        .padding(horizontal = PaddingHalf)
                )
            }
        }

        RowContent {
            Icon(painter = painterResource(id = R.drawable.ic_star), contentDescription = "Stars")
            Text(
                text = "${repository.stars}",
                color = Black,
                fontWeight = Normal,
                fontSize = TextSizeExtraSmall,
                modifier = Modifier.padding(start = PaddingSmall)
            )
            Spacer(modifier = Modifier.width(PaddingHalf))

            if (!repository.language.isNullOrEmpty()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_lang),
                    contentDescription = "Language"
                )
                Text(
                    text = repository.language,
                    color = Black,
                    fontWeight = Normal,
                    fontSize = TextSizeExtraSmall,
                    modifier = Modifier.padding(start = PaddingSmall)
                )
            }
        }

        if (!repository.description.isNullOrEmpty()) {
            Text(
                modifier = Modifier.padding(
                    top = PaddingLarge,
                    start = PaddingHalf,
                    end = PaddingHalf
                ),
                text = repository.description,
                color = Black,
                fontWeight = Normal,
                fontSize = TextSizeExtraSmall,
                maxLines = 2,
                overflow = Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(PaddingDefault))

        if (isForUserDetails == true) {
            Text(
                text = "Updated ${repository.updatedAt.toTimeAgo()}",
                color = DarkGreyText,
                fontSize = TextSizeExtraSmall,
                modifier = Modifier.padding(
                    start = PaddingHalf,
                    end = PaddingHalf,
                    bottom = PaddingDefault
                ),
            )
        } else {
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
                        fontSize = TextSizeExtraSmall,
                        maxLines = 1,
                        overflow = Ellipsis
                    )
                }
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

@Preview
@Composable
fun RepositoryCardPreview() {
    RepositoryCard(
        repository = Repository(
            "DaraAbijo",
            "Wubbaforbeginnerspartoneoftwentyhvvhhvhk",
            "",
            "Description",
            5,
            "Kotlin",
            listOf("Topic1", "Topic2"),
            "Public",
            "4 days ago"
        ), isForUserDetails = true
    )
}
