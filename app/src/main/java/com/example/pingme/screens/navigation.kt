package com.example.pingme.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(modifier: Modifier = Modifier,authviewmodel: Authviewmodel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login"){
            LoginScreen(navController,authviewmodel)
        }
        composable("Signup"){
            Signup(navController,authviewmodel)
        }

        composable("Home"){
            Home(
                navController,
                authviewmodel
            )
        }
    }
}