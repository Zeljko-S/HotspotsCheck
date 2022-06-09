package com.example.hotspotscheck.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hotspotscheck.screens.ChecklistScreen
import com.example.hotspotscheck.screens.DetailScreen
import com.example.hotspotscheck.screens.HomeScreen
import com.example.hotspotscheck.screens.HotspotScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.HomeScreen.name) {

        composable(route = Screens.HomeScreen.name) { HomeScreen(navController = navController)}
        composable(route = Screens.HotspotScreen.name + "/{cityid}", arguments = listOf(navArgument("cityid"){
                type = NavType.StringType
            })
        ) { backStackEntry ->
            HotspotScreen(navController = navController, cityid = backStackEntry.arguments?.getString("cityid"))
        }

        composable(route = Screens.ChecklistScreen.name) { ChecklistScreen(navController = navController)}

        composable(route = Screens.DetailScreen.name + "/{cityid}" + "/{hotspotid}", arguments = listOf(navArgument("hotspotid") {
                type = NavType.StringType
            },
            navArgument("cityid") {
                type = NavType.StringType
            },
            )
        ) { backStackEntry ->
            DetailScreen(navController = navController, cityid = backStackEntry.arguments?.getString("cityid"), hotspotid = backStackEntry.arguments?.getString("hotspotid"))
        }

    }

}