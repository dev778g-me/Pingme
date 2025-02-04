package com.example.pingme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pingme.screens.Authviewmodel
import com.example.pingme.screens.LoginScreen
import com.example.pingme.screens.Navigation
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

