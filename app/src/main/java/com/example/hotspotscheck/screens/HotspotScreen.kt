package com.example.hotspotscheck.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotspotscheck.assets.TopBar
import com.example.hotspotscheck.models.City
import com.example.hotspotscheck.models.getCities
import com.example.hotspotscheck.navigation.Screens

@Composable
fun HotspotScreen(navController: NavController = rememberNavController(), cityid: String?) {

    val city = filtercity(cityid = cityid)

    TopBar(title = city.name,
        onTopbarClick = {
            navController.navigate(route = Screens.ChecklistScreen.name)
        }) {
            Text(text = "Some important text")
        }
}

@Composable
fun Hotstops() {

}


@Composable
fun filtercity(cityid: String?) : City {
    return getCities().filter {city -> city.id == cityid }[0]
}