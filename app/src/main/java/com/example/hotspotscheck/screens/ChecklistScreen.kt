package com.example.hotspotscheck.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotspotscheck.assets.TopBar

@Composable
fun ChecklistScreen(navController: NavController = rememberNavController()) {

    TopBar(title = "HOTSTOP X") {
        Text(text = "WOOW Checklist")
    }
}