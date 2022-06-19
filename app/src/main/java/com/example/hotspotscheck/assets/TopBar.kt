package com.example.hotspotscheck.assets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(title: String, onBackClick: @Composable () -> Unit = {}, onTopbarClick: @Composable () -> Unit = {}, content: @Composable () -> Unit = {} ) {

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = title)
            },
                navigationIcon = {
                    onBackClick()
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.secondary,
                actions = {
                    onTopbarClick()

                }
            )
        }
    ) {
        content()
    }
}

@Composable
fun MenuIcon(onTopbarCheck: () -> Unit = {}, onTopbarPlan: () -> Unit = {}) {

    var showMenu by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = { showMenu = !showMenu }) {
        Icon(imageVector = Icons.Default.Menu, contentDescription = "More")
    }

    DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
        DropdownMenuItem(onClick = { onTopbarCheck() }) {

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
        DropdownMenuItem(onClick = { onTopbarPlan() }) {

            Row() {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Planlist",
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = "Planlist",
                    modifier = Modifier
                        .padding(4.dp)
                        .width(100.dp)
                )

            }
        }

    }

}

@Composable
fun BackIcon(onBackClick: () -> Unit = {}) {

    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow back",
        modifier = Modifier.clickable {
            onBackClick()    // go back to last screen
        })
}