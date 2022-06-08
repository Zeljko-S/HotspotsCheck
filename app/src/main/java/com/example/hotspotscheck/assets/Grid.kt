package com.example.hotspotscheck.assets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.hotspotscheck.models.Hotspot
import com.example.hotspotscheck.navigation.Screens

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Grid(hotspot: Hotspot) {

    var checkchange by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(2.dp)
            .clickable { /*TODO*/ }

    ) {
        Box(contentAlignment = Alignment.BottomCenter) {
            AsyncImage(
                model = hotspot.img,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Row {
                Text(
                    text = hotspot.name,
                    color = Color.White,
                    // style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(2.dp)
                )

                IconButton(onClick = { checkchange = !checkchange }) {

                    if (!checkchange) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Check",
                            modifier = Modifier
                                .padding(2.dp)
                                .clickable { checkchange = !checkchange },
                            tint = Color.White
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Check",
                            modifier = Modifier
                                .padding(2.dp)
                                .clickable { checkchange = !checkchange },
                            tint = Color.Cyan
                        )
                    }
                }
            }
        }
    }
}

