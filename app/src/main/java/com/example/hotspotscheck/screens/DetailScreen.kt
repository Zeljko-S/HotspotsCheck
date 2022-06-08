package com.example.hotspotscheck.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotspotscheck.assets.TopBar
import com.example.hotspotscheck.navigation.Screens

@Composable
fun DetailScreen(navController: NavController = rememberNavController()) {
    TopBar(title = "HOTSTOP X",
        onTopbarClick = {
            navController.navigate(route = Screens.ChecklistScreen.name)
        }) {
        // Text(text = "Some important text")
        Text(text = "coool DetailScreen")
    }


}