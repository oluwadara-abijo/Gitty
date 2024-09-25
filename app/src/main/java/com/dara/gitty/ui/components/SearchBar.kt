package com.dara.gitty.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.dara.gitty.R
import com.dara.gitty.ui.theme.ButtonBg
import com.dara.gitty.ui.theme.Dimens.PaddingDefault
import com.dara.gitty.ui.theme.Dimens.PaddingHalf
import com.dara.gitty.ui.theme.Dimens.PaddingSmall
import com.dara.gitty.ui.theme.GreyText

@Composable
fun SearchBar(
    hint: String,
    searchInput: String = "",
    onSearchInputChanged: (String) -> Unit,
    onSearchClicked: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = PaddingDefault),
        value = searchInput,
        onValueChange = { onSearchInputChanged(it) },
        placeholder = {
            Text(text = hint, color = GreyText, maxLines = 1, fontSize = 14.sp)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_repo_outlined),
                contentDescription = null,
                modifier = Modifier.size(PaddingDefault)
            )
        },
        trailingIcon = {
            Row {
                if (searchInput.isNotEmpty()) {
                    IconButton(onClick = { onSearchInputChanged("") }) {
                        Icon(Icons.Outlined.Clear, contentDescription = "Clear")
                    }
                }
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
            }
        },
        singleLine = true
    )
}
