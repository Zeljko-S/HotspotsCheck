package com.example.hotspotscheck.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotspotscheck.assets.BackIcon
import com.example.hotspotscheck.assets.CheckIcon
import com.example.hotspotscheck.assets.Grid
import com.example.hotspotscheck.assets.TopBar
import com.example.hotspotscheck.models.City
import com.example.hotspotscheck.models.Hotspot
import com.example.hotspotscheck.navigation.Screens
import com.example.hotspotscheck.viewmodels.CheckViewModel

@Composable
fun ChecklistScreen(navController: NavController = rememberNavController(), viewModel: CheckViewModel = viewModel()/*, cityid: String?*/) {

    val hotspots = viewModel.checkHotspots
   // val city = filtercity(cityid = cityid)

    TopBar(title = "Checklist",
        onBackClick = {
            BackIcon() {
                navController.popBackStack()
            }
        },
    ) {
       // Text(text = "WOOW Checklist")
        CheckedHotspots(hotspots = hotspots, navController = navController, viewModel = viewModel/*, city = city*/)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CheckedHotspots(hotspots: List<Hotspot>, navController: NavController, viewModel: CheckViewModel/*, city: City*/) {

    LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(2.dp)) {

        items(hotspots) { hotspot ->
            Grid(hotspot = hotspot, onHotspotClick = {
         //       navController.navigate(route = Screens.DetailScreen.name + "/${city.id}" + "/${hotspot.id}")
            }) {

                CheckIcon(isChecked = viewModel.checkVisit(hotspot), onCheckClick = {
                    if (!viewModel.checkVisit(hotspot)) {
                        viewModel.addCheck(hotspot)
                    } else {
                        viewModel.removeCheck(hotspot)
                    }
                })

            }
        }


    }

}