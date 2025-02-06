package com.example.pingme.auth.screens

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pingme.auth.repo.Authviewmodel

//import com.example.pingme.screens.SettingScreen
//import com.example.pingme.screens.StatusScreen
//import com.google.firebase.Firebase
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.auth
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
//@Composable
//fun Navigation(modifier: Modifier = Modifier,authviewmodel: Authviewmodel) {
//     lateinit var authi : FirebaseAuth
//     var auth = Firebase.auth
//    val currentUser = auth.currentUser
//    val navController = rememberNavController()
//
//
//        NavHost(
//            navController = navController,
//            startDestination =
//            if (currentUser != null) {
//                "Home"
//            } else {
//                "login"
//            }
//        ) {
//            composable("login") {
//                LoginScreen(navController, authviewmodel)
//            }
//            composable("Signup") {
//                Signup(navController, authviewmodel)
//            }
//
//            composable("Home") {
//                Home(
//                    navController,
//                    authviewmodel
//                )
//            }
//            composable("Settings") {
//                SettingScreen(navController)
//            }
//            composable("Status") {
//                StatusScreen(navController)
//            }
//        }
//
//
//}