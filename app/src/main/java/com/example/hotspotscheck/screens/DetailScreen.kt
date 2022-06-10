package com.example.hotspotscheck.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotspotscheck.assets.BackIcon
import com.example.hotspotscheck.assets.TopBar
import com.example.hotspotscheck.models.City
import com.example.hotspotscheck.models.Hotspot
import com.example.hotspotscheck.models.getCities
import com.example.hotspotscheck.navigation.Screens
import com.example.hotspotscheck.viewmodels.CheckViewModel
import okhttp3.internal.cookieToString

@Composable
fun DetailScreen(navController: NavController = rememberNavController(), cityid: String?, hotspotid: String?, viewModel: CheckViewModel = viewModel()) {

    val hotspot = filterhotspot(cityid = cityid, hotspotid = hotspotid)

  //  if (hotspot != null) {
        TopBar(title = hotspot.name,
            onBackClick = {
                BackIcon() {
                    navController.popBackStack()
                }
            },
            onTopbarClick = {
                //    navController.navigate(route = Screens.ChecklistScreen.name)
            }) {
            // Text(text = "Some important text")
            Text(text = "coool DetailScreen")
        }
  //  }

}

@Composable
fun filterhotspot(cityid: String?, hotspotid: String?) : Hotspot {
     val city = filtercity(cityid = cityid)

    return city.hotspots.filter { hotspot -> hotspot.id == hotspotid }[0]
}

/*@Composable
fun filterhotspot(/*cityid: String?,*/ hotspotid: String?) : Hotspot? {
  //  val city = filtercity(cityid = cityid)

    val cities = getCities()

    cities.forEach { city ->
        city.hotspots.forEach{ hotspot ->
            if (hotspot.id == hotspotid) {
                return hotspot
            }
        }
    }

    return null

}*/