package com.example.pingme.auth.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pingme.auth.repo.Authviewmodel
import com.example.pingme.screens.Home
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

@Composable
fun Navigation(modifier: Modifier = Modifier,authviewmodel: Authviewmodel) {
     lateinit var authi : FirebaseAuth
     var auth = Firebase.auth
    val navController = rememberNavController()
    val currentUser = auth.currentUser
    NavHost(
        navController = navController,
        startDestination =
        if (currentUser != null) {
            "Home"
        } else {
            "login"
        }
    ) {
        composable("login") {
            LoginScreen(navController, authviewmodel)
        }
        composable("Signup") {
            Signup(navController, authviewmodel)
        }

        composable("Home") {
            Home(
                navController,
                authviewmodel
            )
        }
    }
}