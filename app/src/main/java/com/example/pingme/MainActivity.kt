package com.example.pingme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.example.pingme.auth.repo.Authviewmodel
import com.example.pingme.auth.screens.Loginpage
import com.example.pingme.screens.Containerscreen
import com.example.pingme.screens.Settings

import com.example.pingme.ui.theme.PingmeTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authviewmodel = Authviewmodel()
        val Firebase = Firebase.auth

        setContent {
            PingmeTheme {

              //  Text(text = "rkjskgbowi")

          if (Firebase.currentUser != null){
              Navigator(Containerscreen)
          } else{
              Navigator(Loginpage)
          }

            }
        }
    }
}

