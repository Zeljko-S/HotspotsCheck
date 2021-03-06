package com.example.hotspotscheck.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.hotspotscheck.assets.BackIcon
import com.example.hotspotscheck.assets.CheckIcon
import com.example.hotspotscheck.assets.Grid
import com.example.hotspotscheck.assets.TopBar
import com.example.hotspotscheck.models.City
import com.example.hotspotscheck.models.Hotspot
import com.example.hotspotscheck.models.getCities
import com.example.hotspotscheck.navigation.Screens
import com.example.hotspotscheck.viewmodels.CheckViewModel

@Composable
fun HotspotScreen(navController: NavController = rememberNavController(), cityid: String?, viewModel: CheckViewModel = viewModel()) {

    val city = filtercity(cityid = cityid)

    TopBar(title = city.name,
        onBackClick = {
            BackIcon() {
                navController.popBackStack()
            }
        },
        onTopbarClick = {

        }) {
        Hotspots(navController = navController, city = city, viewModel = viewModel)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Hotspots(navController: NavController, city: City, viewModel: CheckViewModel) {

    LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(2.dp)) {

        items(city.hotspots) { hotspot ->
            Grid(hotspot = hotspot, onHotspotClick = {
                navController.navigate(route = Screens.DetailScreen.name + "/${city.id}" + "/${hotspot.id}")
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

@Composable
fun filtercity(cityid: String?) : City {
    return getCities().filter {city -> city.id == cityid }[0]
}