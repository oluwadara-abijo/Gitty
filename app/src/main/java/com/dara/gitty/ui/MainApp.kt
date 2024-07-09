package com.dara.gitty.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dara.gitty.navigation.MainNavHost
import com.dara.gitty.navigation.navigateBottomTab
import com.dara.gitty.ui.components.BottomNavBar
import com.dara.gitty.ui.theme.GittyTheme

/**
 *
 * This is the root composable function for the application, responsible for setting up the main
 * UI structure and integrating the navigation graph.
 */

@Composable
internal fun MainApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    GittyTheme {
        Scaffold(
            modifier = Modifier.background(Color.White),
            bottomBar = {
                BottomNavBar(
                    currentDestination = currentDestination,
                    onBottomTabSelected = navController::navigateBottomTab
                )
            }
        ) { paddingValues ->
            MainNavHost(
                navController = navController,
                modifier = Modifier.padding(paddingValues)
            )

        }
    }

}

@Preview
@Composable
fun MainAppPreview() {
    MainApp()
}

