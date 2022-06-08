package com.example.hotspotscheck.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
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
           // Text(text = "Some important text")
            Hotspots(city.hotspotimgs)
        }
}





@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Hotspots(hotspotlist: List<String>) {
    LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(2.dp)) {
        items(hotspotlist) { hotspot ->
            Card(
                modifier = Modifier.padding(2.dp),

            ) {
                Box(contentAlignment = Alignment.BottomStart) {
                    AsyncImage(
                        model = hotspot,
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = "Hallo Zeljko",
                        color = Color.White,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        }
    }

}


@Composable
fun filtercity(cityid: String?) : City {
    return getCities().filter {city -> city.id == cityid }[0]
}