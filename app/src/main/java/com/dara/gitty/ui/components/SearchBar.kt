package com.dara.gitty.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.dara.gitty.R
import com.dara.gitty.ui.theme.ButtonBg
import com.dara.gitty.ui.theme.Dimens.PaddingDefault
import com.dara.gitty.ui.theme.Dimens.PaddingHalf
import com.dara.gitty.ui.theme.Dimens.PaddingSmall
import com.dara.gitty.ui.theme.GreyText

@Composable
fun SearchBar(
    hint: String,
    onSearchClicked: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    var searchInput by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = PaddingDefault),
        value = searchInput,
        onValueChange = { searchInput = it },
        placeholder = {
            Text(text = hint, color = GreyText)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_repo_outlined),
                contentDescription = null,
                modifier = Modifier.size(PaddingDefault)
            )
        },
        trailingIcon = {
            Button(
                modifier = Modifier.padding(end = PaddingSmall),
                onClick = {
                    onSearchClicked(searchInput)
                    focusManager.clearFocus()
                },
                colors = ButtonDefaults.buttonColors(containerColor = ButtonBg),
                shape = RoundedCornerShape(PaddingHalf),
                enabled = searchInput.isNotEmpty()
            ) {
                Text(text = stringResource(R.string.search))
            }
        },
    )
}
