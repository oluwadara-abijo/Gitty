package com.dara.gitty.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dara.gitty.navigation.Screen.Home
import com.dara.gitty.navigation.Screen.Repositories
import com.dara.gitty.navigation.Screen.UserDetail
import com.dara.gitty.navigation.Screen.Users
import com.dara.gitty.repos.ui.RepositoriesScreen
import com.dara.gitty.ui.composables.HomeScreen
import com.dara.users.ui.composables.UserDetailScreen
import com.dara.users.ui.composables.UsersScreen


/**
 * Defines the main navigation graph for the application using Jetpack Compose Navigation.
 * It sets up the routes for different screens and handles navigation between them.
 */

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier,
) {

    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = Home.route
    ) {
        composable(Home.route) {
            HomeScreen(
                navigateToUsers = {
                    navController.navigateBottomTab(Users.route)
                },
                navigateToRepos = { navController.navigateBottomTab(Repositories.route) }
            )
        }
        composable(Repositories.route) { RepositoriesScreen() }
        composable(Users.route) {
            UsersScreen(
                navigateToUserDetail = { name ->
                    navController.navigate("${UserDetail.route}/$name")
                }
            )
        }
        composable(
            route = "${UserDetail.route}/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) {
            UserDetailScreen(
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}

//Navigation routes
sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Repositories : Screen("repositories")
    data object Users : Screen("users")
    data object UserDetail : Screen("users/user-detail")
}
