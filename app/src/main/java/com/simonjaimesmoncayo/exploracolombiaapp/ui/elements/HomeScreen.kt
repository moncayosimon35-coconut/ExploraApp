package com.simonjaimesmoncayo.exploracolombiaapp.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClickAddTouristicPlace: () -> Unit,
    onLogout: () -> Unit // <--- PASO 1: Agregar este parámetro faltante
) {
    val auth = Firebase.auth
    // val user = auth.currentUser // No se usa por ahora, pero está bien tenerlo

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Explora Colombia") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onClickAddTouristicPlace) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido
        ) {

            Text(text = "Bienvenido a la aplicación", modifier = Modifier.padding(16.dp))

            // Espacio entre el texto y el botón
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    Firebase.auth.signOut()
                    onLogout() // <--- PASO 2: Ahora sí existe y funcionará
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp) // Un poco más alto por el padding
                    .padding(16.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE53935),
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = "Logout icon",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "CERRAR SESIÓN",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.25.sp
                    )
                )
            }
        }
    }
}