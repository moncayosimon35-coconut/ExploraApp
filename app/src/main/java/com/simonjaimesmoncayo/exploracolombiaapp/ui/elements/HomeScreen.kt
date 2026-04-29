package com.simonjaimesmoncayo.exploracolombiaapp.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onClickAddTouristicPlace: () -> Unit) {
    val auth = Firebase.auth
    val user = auth.currentUser

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Explora Colombia") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {onClickAddTouristicPlace}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            Text(text = "Bienvenido a la aplicación", modifier = Modifier.padding(16.dp))
        }
    }
}