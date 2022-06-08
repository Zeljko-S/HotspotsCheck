package com.example.hotspotscheck.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
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
import com.example.hotspotscheck.models.Hotspot
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
            Hotspots(city.hotspots, hotspotnamelist = city.hotstopnamelist, navController = navController)
        }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Hotspots(hotspotimglist: List<Hotspot>, hotspotnamelist: List<String>, navController: NavController) {

    LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(2.dp)) {
        items(hotspotimglist) { hotspot ->
            //items(hotspotnamelist) { hotspotname ->
                Card(
                    modifier = Modifier
                        .padding(2.dp)
                        .clickable { navController.navigate(route = Screens.DetailScreen.name) }

                ) {
                    Box(contentAlignment = Alignment.BottomStart) {
                        AsyncImage(
                            model = hotspot.img,
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth
                        )
                        Row {
                            Text(
                                text = hotspot.name,
                                color = Color.White,
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.Bold,
                             //   modifier = Modifier.padding(0.dp)
                            )

                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Check",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                tint = Color.White
                            )

                        }


                  //  }
                }
            }

        }
    }

}

/*@Composable
fun CheckIcon() {

}*/


@Composable
fun filtercity(cityid: String?) : City {
    return getCities().filter {city -> city.id == cityid }[0]
}