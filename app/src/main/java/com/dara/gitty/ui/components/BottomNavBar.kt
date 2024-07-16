package com.dara.gitty.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import com.dara.gitty.R
import com.dara.gitty.navigation.Screen
import com.dara.gitty.ui.theme.Dimens.PaddingHalf

@Composable
fun BottomNavBar(
    currentDestination: NavDestination?,
    onBottomTabSelected: (String) -> Unit,
) {
    Surface(shadowElevation = PaddingHalf) {
        NavigationBar(
            containerColor = White,
        ) {
            BOTTOM_TABS.forEach { tab ->
                val selected = currentDestination?.route == tab.startDestination
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = White,
                        unselectedTextColor = Black,
                        selectedTextColor = Black,
                        selectedIconColor = Black,
                        unselectedIconColor = Black
                    ),
                    selected = selected,
                    onClick = { onBottomTabSelected(tab.startDestination) },
                    label = { Text(text = stringResource(id = tab.title)) },
                    icon = {
                        Icon(
                            painter = painterResource(id = if (selected) tab.selectedIcon else tab.unselectedIcon),
                            contentDescription = null,
                        )
                    })
            }
        }
    }
}

data class BottomTab(
    val startDestination: String,
    @StringRes val title: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int
)

val BOTTOM_TABS = listOf(
    BottomTab(
        startDestination = Screen.Home.route,
        title = R.string.home,
        selectedIcon = R.drawable.ic_home_filled,
        unselectedIcon = R.drawable.ic_home_outlined
    ),
    BottomTab(
        startDestination = Screen.Repositories.route,
        title = R.string.repositories,
        selectedIcon = R.drawable.ic_repo_filled,
        unselectedIcon = R.drawable.ic_repo_outlined
    ),
    BottomTab(
        startDestination = Screen.Users.route,
        title = R.string.users,
        selectedIcon = R.drawable.ic_users_filled,
        unselectedIcon = R.drawable.ic_users_outlined
    ),
)
