package com.dara.gitty.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.dara.gitty.R
import com.dara.gitty.ui.theme.Dimens.CardHeight
import com.dara.gitty.ui.theme.Dimens.PaddingDefault
import com.dara.gitty.ui.theme.Dimens.PaddingDouble
import com.dara.gitty.ui.theme.Dimens.PaddingExtraLarge
import com.dara.gitty.ui.theme.Dimens.PaddingHalf
import com.dara.gitty.ui.theme.Dimens.PaddingLarge
import com.dara.gitty.ui.theme.Dimens.TextSizeLarge
import com.dara.gitty.ui.theme.Dimens.TextSizeTitle
import com.dara.gitty.ui.theme.manropeFamily

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = PaddingLarge, vertical = PaddingExtraLarge)
    ) {
        Text(
            text = stringResource(id = R.string.home),
            fontFamily = manropeFamily,
            fontWeight = FontWeight.Bold,
            fontSize = TextSizeTitle
        )

        Spacer(modifier = Modifier.height(PaddingDouble))

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            MenuCard(
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFECF5F8),
                icon = R.drawable.ic_users_menu,
                labelRes = R.string.users
            )
            Spacer(modifier = Modifier.width(PaddingDefault))
            MenuCard(
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFF6EDF8),
                icon = R.drawable.ic_repos_menu,
                labelRes = R.string.repositories
            )
        }

    }
}

@Composable
fun MenuCard(
    modifier: Modifier,
    backgroundColor: Color,
    icon: Int,
    labelRes: Int,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(CardHeight)
            .background(color = backgroundColor)
            .padding(PaddingDefault),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .background(color = White)
                .padding(PaddingHalf)
        )
        Text(
            text = stringResource(id = labelRes),
            fontFamily = manropeFamily,
            fontWeight = FontWeight.Bold,
            fontSize = TextSizeLarge
        )
    }
}

@Preview
@Composable
fun CardPreview() {
    HomeScreen()
}