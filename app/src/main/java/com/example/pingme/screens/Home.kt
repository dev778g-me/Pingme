package com.example.pingme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.pingme.auth.repo.Authviewmodel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController,authviewmodel: Authviewmodel) {
    var opendialog by remember { mutableStateOf(false) }
    val authstate = authviewmodel.authstate.observeAsState()
          Scaffold (
              topBar = {
                  TopAppBar(
                      title = {
                          Text(text = "Home")
                      }, actions = {
                          IconButton(onClick = {
                              opendialog = true
                              // authviewmodel.signout()
                          }) {
                              // Text(text = "irgvo")
                              Icon(
                                  imageVector = Icons.AutoMirrored.Default.ExitToApp,
                                  contentDescription = "Logout"
                              )

                          }

                      }
                  )
              }


          ){
             if (opendialog){

                 AlertDialog(
                     title = {
                         Text(
                             text = "Logging Out"
                         )
                     },
                     text = {
                         Text(text = "Are you sure you want to logout?")
                     },
                     onDismissRequest = {
                         opendialog = false
                     },
                     confirmButton = {
                         TextButton(onClick = {
                             authviewmodel.signout()
                         }) {
                             Text(text = "LogOut", color = Color.Red)
                         }
                     },

                     dismissButton = {
                         TextButton(onClick = {
                             opendialog = false
                         }) {
                             Text(text = "Cancel")
                         }
                     }

                 )
             }

              Column() {

              }
          }
}