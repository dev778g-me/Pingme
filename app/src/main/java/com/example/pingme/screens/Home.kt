package com.example.pingme.screens

import android.annotation.SuppressLint
import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController,authviewmodel: Authviewmodel) {
    val authstate = authviewmodel.authstate.observeAsState()
          Scaffold (
              topBar = {
                  TopAppBar(
                      title = {
                          Text(text = "home")
                      }
                      , actions = {
                          IconButton(onClick = {
                              authviewmodel.signout()
                          }) {
                              Text("Sign out")
                          }

                      }
                  )
              }
          ){

              Column (){

              }
          }
}