package com.example.hotspotscheck.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotspotscheck.assets.BackIcon
import com.example.hotspotscheck.assets.CheckIcon
import com.example.hotspotscheck.assets.Grid
import com.example.hotspotscheck.assets.TopBar
import com.example.hotspotscheck.models.Hotspot
import com.example.hotspotscheck.navigation.Screens
import com.example.hotspotscheck.viewmodels.CheckViewModel

@Composable
fun PlanlistScreen(navController: NavController = rememberNavController(), viewModel: CheckViewModel = viewModel()) {

    val hotspots = viewModel.planhotspots

    TopBar(title = "Planlist",
        onBackClick = {
            BackIcon() {
                navController.popBackStack()
            }
        },
    ) {
        PlannedHotspots(hotspots = hotspots, navController = navController)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlannedHotspots(hotspots: List<Hotspot>, navController: NavController) {

    LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(2.dp)) {

        items(hotspots) { hotspot ->
            Grid(hotspot = hotspot, onHotspotClick = {
                navController.navigate(route = Screens.DetailScreen.name + "/${hotspot.cityid}" + "/${hotspot.id}")
            })
        }

    }

}