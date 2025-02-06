package com.example.pingme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import cafe.adriel.voyager.core.screen.Screen
import java.lang.reflect.Modifier

// Settings screen implementing Voyager's Screen interface
object Settings : Screen {
    @Composable
    override fun Content() {
        Column(

        ) {
            Text(text = "Settings Screen",)
        }
    }
}