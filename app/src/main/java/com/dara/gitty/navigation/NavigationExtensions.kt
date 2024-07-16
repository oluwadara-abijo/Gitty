package com.dara.gitty.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

/**
 * Finds the start destination of the [NavHostController]'s graph and pops the back
 * stack to that destination; while saving and restoring state of the popped and navigated-to
 * routes.
 *
 * This is used in cases where the bottom navigation tabs each house a backstack of destinations
 * which should be saved and restored across navigation targets.
 *
 * @param route The route that should be navigated to
 */
internal fun NavHostController.navigateBottomTab(
    route: String,
) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            // Saves the state of the exiting destination, when its popped
            saveState = true
        }
        // Prevent relaunching new instances on re-selecting the same destination
        launchSingleTop = true
        // Restores the state of the new navigated-to destination, if it exists.
        restoreState = true
    }
}
