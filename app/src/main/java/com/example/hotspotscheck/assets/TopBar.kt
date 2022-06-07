package com.example.hotspotscheck.assets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(title: String, onTopbarClick: () -> Unit = {}, content: @Composable () -> Unit = {} ) {

    var showMenu by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = title) }, backgroundColor = Color.Cyan,
                actions = {
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "More")
                    }

                    DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(onClick = { onTopbarClick() }) {
                            Row() {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Checklist",
                                    modifier = Modifier.padding(4.dp)
                                )
                                Text(
                                    text = "Checklist",
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .width(100.dp)
                                )

                            }
                        }
                    }
                }
            )
        }
    ) {
        content()
    }
}