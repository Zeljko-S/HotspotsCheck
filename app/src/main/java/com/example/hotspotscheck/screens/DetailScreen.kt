package com.example.hotspotscheck.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.hotspotscheck.assets.BackIcon
import com.example.hotspotscheck.assets.TopBar
import com.example.hotspotscheck.viewmodels.CheckViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.hotspotscheck.models.*


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
          //  Text(text = "coool DetailScreen")
            DetailContent(hotspot = hotspot, viewModel = viewModel, cityid = cityid)
        }
  //  }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailContent(hotspot: Hotspot, viewModel: CheckViewModel, cityid: String?) {

    Column {
        AddVisitDate(ischecked = viewModel.checkVisit(hotspot), hotspot = hotspot, datetext = {
            viewModel.filterCheckedHotspot(hotspot)?.visitdate?.let { Text(text = it) }
           // hotspot.visitdate?.let { Text(text = it) }

        }) { newdate ->
            if (!viewModel.checkVisit(hotspot)) {
                viewModel.addCheck(hotspot)
                viewModel.changeVisitDate(hotspot, newdate)

                /*          val newVisitDate = cityid?.let { VisitDate(cityid = it, hotspotid = hotspot.id, datum = newdate) }
                      if (newVisitDate != null) {
                          viewModel.addCheck(newVisitDate)
                      }*/

            } else {
                viewModel.changeVisitDate(hotspot, null)
                viewModel.removeCheck(hotspot)
            }
        }

     /*   val date = filterdate(hotspotid = hotspot.id)
        val date = viewModel.dates.filter { date -> date.cityid == cityid && date.hotspotid == hotspot.id}[0]
        Text(text = date.datum)*/

       /* viewModel.dates.forEach { date ->
            Text(text = date.datum)
        }*/


            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                elevation = 6.dp,


                ) {
                Column(modifier = Modifier.padding(5.dp)) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "General Information:",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = hotspot.text, textAlign = TextAlign.Justify)




                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider()
            Spacer(modifier = Modifier.height(10.dp))


            PlanIcon(ischecked = viewModel.checkPlan(hotspot = hotspot)) {
                if (!viewModel.checkPlan(hotspot)) {
                    viewModel.addPlan(hotspot)
                } else {
                    viewModel.removePlan(hotspot)
                }
            }


            /*   LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(2.dp)) {

                   items(hotspot.img) { hotspotimg ->
                       AsyncImage(
                           model = hotspotimg,
                           contentDescription = null,
                           contentScale = ContentScale.FillWidth
                       )
                   }
               }*/

            Gallery(hotspot = hotspot)
        }

    }


@Composable
fun Gallery(hotspot: Hotspot) {
    LazyRow{
        items(hotspot.img){ image ->

            Card(modifier = Modifier
                .padding(12.dp)
                .size(240.dp),
                elevation = 4.dp,
            ) {

                AsyncImage(
                    model = image,
                    contentDescription = "hotspot image",
                )
            }

        }
    }
}

@Composable
fun AddVisitDate(ischecked: Boolean = false, hotspot: Hotspot, datetext: @Composable () -> Unit = {}, onSubmitClick: (String) -> Unit = {}) {

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        var text by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Visit Date", style = MaterialTheme.typography.h6)

        OutlinedTextField(
            value = text,
            onValueChange = { value -> text = value},
            label = { Text(text = "DD:MM:JJJJ") }
        )
        Spacer(modifier = Modifier.height(10.dp))


       // hotspot.visitdate?.let { Text(text = it) }
        datetext()


        if (!ischecked) {
            Button(colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.secondary),
                onClick = {
                if (text.isNotEmpty()) {
             //       hotspot.visitdate = text

                    onSubmitClick(text)

                    text = ""
                }

            }) {
                Text(text = "Save")
            }
        } else {
            Button(colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.secondary),
                onClick = {
             //       hotspot.visitdate = text

                    onSubmitClick(text)

                  //  text = ""


            }) {
                Text(text = "Delete")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

    }



}


@Composable
fun PlanIcon(ischecked: Boolean, onPlanClick: () -> Unit = {}) {

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        if (!ischecked) {
            Button(colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.secondary),
                onClick = {
                    onPlanClick()

                }) {
                Text(text = "Mark as planned")
            }
        } else {
            Button(colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.secondary),
                onClick = {
                    onPlanClick()

                }) {
                Text(text = "Remove from planned")
            }
        }
    }

}


@Composable
fun filterhotspot(cityid: String?, hotspotid: String?) : Hotspot {
    val city = filtercity(cityid = cityid)

    return city.hotspots.filter { hotspot -> hotspot.id == hotspotid }[0]
}

/*@Composable
fun filterdate(hotspotid: String?) : VisitDate {
  //  val city = filtercity(cityid = cityid)

    return getDates().filter { date -> date.hotspotid == hotspotid }[0]
}*/

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