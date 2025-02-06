package com.example.pingme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.pingme.auth.repo.Authstate
import com.example.pingme.auth.repo.Authviewmodel
import com.example.pingme.auth.screens.Loginpage


import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
 object Containerscreen : Screen {
    @Composable
    override fun Content() {

        val authviewmodel = remember { Authviewmodel() }
            var opendialog by remember { mutableStateOf(false) }
            data class bottomnavitem(
                val title :String,
                val selectedicon : ImageVector,
                val unselectedicon : ImageVector,
                val route : String,

                )
        val navigator = LocalNavigator.current
            var selectedindex by remember { mutableStateOf(0) }
            val item =   listOf(
                bottomnavitem(
                    title = "Chats",
                    selectedicon = Icons.Default.Chat,
                    unselectedicon = Icons.Outlined.Chat,
                    route = ""
                ),
                bottomnavitem(
                    title = "Status",
                    selectedicon = Icons.Default.Favorite,
                    unselectedicon = Icons.Outlined.FavoriteBorder,
                    route = "Status"
                ),
                bottomnavitem(
                    title = "Settings",
                    selectedicon = Icons.Default.Settings,
                    unselectedicon = Icons.Outlined.Settings,
                    route = ""
                )

            )
            Scaffold (
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Home")
                        }, actions = {
                            IconButton(onClick = {
                                opendialog = true


                            }) {
                                // Text(text = "irgvo")
                                Icon(
                                    imageVector = Icons.AutoMirrored.Default.ExitToApp,
                                    contentDescription = "Logout"
                                )

                            }

                        }
                    )
                }, bottomBar = {
                    NavigationBar {

                        item.forEachIndexed { index, item ->
                            NavigationBarItem(
                                alwaysShowLabel = false,
                                selected = selectedindex == index,
                                onClick = {
                                    selectedindex = index
                                    //
                                },
                                label = {
                                    Text(text = item.title)
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (selectedindex == index) {
                                            item.selectedicon
                                        } else {
                                            item.unselectedicon
                                        },
                                        contentDescription = item.title
                                    )
                                }
                            )
                        }
                    }
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
                                if(authviewmodel.authstate.value == Authstate.unauthenticated){
                                   navigator?.pop()
                                    navigator?.push(Loginpage)
                                }
                                opendialog = false
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

                Column {

                }
            }




    }

}
