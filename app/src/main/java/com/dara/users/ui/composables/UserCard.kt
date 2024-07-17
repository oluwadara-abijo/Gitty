package com.dara.users.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dara.gitty.ui.theme.BlueText
import com.dara.gitty.ui.theme.Dimens
import com.dara.gitty.ui.theme.Dimens.CardElevation
import com.dara.gitty.ui.theme.Dimens.PaddingDefault
import com.dara.gitty.ui.theme.Dimens.PaddingHalf
import com.dara.gitty.ui.theme.Dimens.PaddingSmall
import com.dara.users.data.model.User

@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = PaddingHalf),
        elevation = CardDefaults.cardElevation(defaultElevation = CardElevation),
        shape = RoundedCornerShape(PaddingSmall),
        colors = CardDefaults.cardColors(containerColor = White),
    ) {
        Row(
            modifier = Modifier.padding(PaddingDefault),
            verticalAlignment = CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(Dimens.PaddingLarge)
                    .clip(CircleShape),
                model = user.avatarUrl,
                contentDescription = user.name,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.width(PaddingDefault))
            Text(
                text = user.name,
                color = BlueText,
                fontWeight = SemiBold,
                maxLines = 1
            )
        }
    }
}