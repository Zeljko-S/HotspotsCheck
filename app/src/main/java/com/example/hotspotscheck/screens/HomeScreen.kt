package com.example.hotspotscheck.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.hotspotscheck.models.City
import com.example.hotspotscheck.models.getCities

@Composable
fun HomeScreen() {

    Cities()



}

@Composable
fun Cities(citylist: List<City> = getCities()) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val zeljko: String

    LazyColumn() {
        items(citylist) { city ->
            Column {
                Card(modifier = Modifier
                    .clickable { /* TODO() */ }
                    .height(screenHeight/4)
                    .fillMaxWidth()
                )
                {
                    AsyncImage(model = city.img, contentDescription = null, contentScale = ContentScale.FillWidth)


                }
                Surface(modifier = Modifier
                    //   .clickable { /* TODO() */ }
                    .fillMaxWidth()
                    .padding(4.dp)
                    .background(color = Color.Black) //HINTERGRUNDFARBE ANSCHAUEN


                )
                {
                    Text(text = city.name, style = MaterialTheme.typography.h4)
                }
            }

        }

    }
}

