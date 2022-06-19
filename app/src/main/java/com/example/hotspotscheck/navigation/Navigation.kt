package com.example.hotspotscheck.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hotspotscheck.screens.*
import com.example.hotspotscheck.viewmodels.CheckViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()
    val checkViewModel: CheckViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screens.HomeScreen.name) {

        composable(route = Screens.HomeScreen.name) { HomeScreen(navController = navController)}
        composable(route = Screens.HotspotScreen.name + "/{cityid}", arguments = listOf(navArgument("cityid"){
                type = NavType.StringType
            })
        ) { backStackEntry ->
            HotspotScreen(navController = navController, cityid = backStackEntry.arguments?.getString("cityid"), viewModel = checkViewModel)
        }

        composable(route = Screens.ChecklistScreen.name) { ChecklistScreen(navController = navController, viewModel = checkViewModel) }

        composable(route = Screens.DetailScreen.name + "/{cityid}" + "/{hotspotid}", arguments = listOf(navArgument("hotspotid") {
                type = NavType.StringType
            },
            navArgument("cityid") {
                type = NavType.StringType
            },
            )
        ) { backStackEntry ->
            DetailScreen(
                navController = navController,
                cityid = backStackEntry.arguments?.getString("cityid"),
                hotspotid = backStackEntry.arguments?.getString("hotspotid"),
                viewModel = checkViewModel
            )
        }

        composable(route= Screens.PlanlistScreen.name) { PlanlistScreen(navController = navController, viewModel = checkViewModel) }

    }
}