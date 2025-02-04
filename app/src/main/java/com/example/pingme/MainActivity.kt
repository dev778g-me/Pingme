package com.example.pingme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pingme.auth.repo.Authviewmodel
import com.example.pingme.auth.screens.Navigation
import com.example.pingme.ui.theme.PingmeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authviewmodel = Authviewmodel()
        setContent {
            PingmeTheme {
               Navigation(authviewmodel = authviewmodel)
            }
        }
    }
}

