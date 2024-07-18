package com.dara.users.ui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dara.gitty.R
import com.dara.gitty.ui.composables.CircleImage
import com.dara.gitty.ui.theme.DarkGreyText
import com.dara.gitty.ui.theme.Dimens
import com.dara.gitty.ui.theme.Dimens.PaddingDefault
import com.dara.gitty.ui.theme.Dimens.PaddingDouble
import com.dara.gitty.ui.theme.Dimens.PaddingHalf
import com.dara.gitty.ui.theme.Dimens.PaddingLarge
import com.dara.gitty.ui.theme.Dimens.PaddingSmall
import com.dara.gitty.ui.theme.SliderColor

@Composable
fun UserDetailScreen() {
}

@Composable
fun UserDetailScreenContent() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(vertical = PaddingDouble, horizontal = PaddingLarge)
    ) {
        Row(verticalAlignment = CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = stringResource(R.string.back)
            )
            Spacer(modifier = Modifier.width(PaddingLarge))
            Text(
                text = stringResource(id = R.string.users),
                fontWeight = FontWeight.SemiBold,
                fontSize = Dimens.TextSizeDefault
            )
        }
        Spacer(modifier = Modifier.height(PaddingLarge))
        Row {
            CircleImage(url = "", size = Dimens.PaddingExtraLarge)
            Spacer(modifier = Modifier.width(PaddingLarge))
            Column {
                Text(
                    text = "Paige Brown",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = Dimens.TextSizeLarge
                )
                Text(
                    text = "DynamicWebPaige",
                    fontWeight = FontWeight.Normal,
                    fontSize = Dimens.TextSizeLarge
                )
            }
        }
        Spacer(modifier = Modifier.height(PaddingLarge))
        Text("This is a random bio, which will be replace with actual content")
        Spacer(modifier = Modifier.height(PaddingLarge))
        Row(verticalAlignment = CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = stringResource(R.string.back)
            )
            Spacer(modifier = Modifier.width(PaddingSmall))
            Text(text = "Lagos, Nigeria", color = DarkGreyText)
            Spacer(modifier = Modifier.width(PaddingDefault))
            Icon(
                painter = painterResource(id = R.drawable.ic_link),
                contentDescription = stringResource(R.string.back)
            )
            Spacer(modifier = Modifier.width(PaddingSmall))
            Text(text = "http://www.paige.com")
        }
        Spacer(modifier = Modifier.height(PaddingHalf))
        Row(verticalAlignment = CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_followers),
                contentDescription = stringResource(R.string.followers)
            )
            Spacer(modifier = Modifier.width(PaddingSmall))
            Text(text = "400 followers  .", color = DarkGreyText)
            Spacer(modifier = Modifier.width(PaddingHalf))
            Text(text = "30 following", color = DarkGreyText)
        }
        Spacer(modifier = Modifier.height(PaddingLarge))
        Row {
            Text(text = "Repositories")
            Spacer(modifier = Modifier.width(PaddingHalf))
            Text(
                text = "200",
                Modifier
                    .background(color = SliderColor, shape = CircleShape)
                    .padding(horizontal = 6.dp)
            )
        }
        Spacer(modifier = Modifier.height(PaddingSmall))
        TwoColorLine()

        Spacer(modifier = Modifier.height(PaddingSmall))
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

@Preview
@Composable
fun UserDetailScreenPreview() {
    UserDetailScreenContent()
}