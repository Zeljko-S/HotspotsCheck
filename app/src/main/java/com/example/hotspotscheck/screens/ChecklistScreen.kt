package com.example.hotspotscheck.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotspotscheck.assets.BackIcon
import com.example.hotspotscheck.assets.TopBar

@Composable
fun ChecklistScreen(navController: NavController = rememberNavController()) {

    TopBar(title = "Checklist",
        onBackClick = {
            BackIcon() {
                navController.popBackStack()
            }
        },
    ) {
        Text(text = "WOOW Checklist")
    }
}