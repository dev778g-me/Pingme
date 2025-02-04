package com.example.pingme.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, authviewmodel: Authviewmodel) {
var emailtext by remember { mutableStateOf("") }
    var passwordtext by remember { mutableStateOf("") }
    var showpassword by remember { mutableStateOf(false) }
    val authstate = authviewmodel.authstate.observeAsState()
    val context = LocalContext.current
    LaunchedEffect(authstate.value) {
        when (authstate.value) {
            is Authstate.authenticated -> navController.navigate("Home")
            is Authstate.Error -> Toast.makeText(
                context,

                (authstate.value as Authstate.Error).message, Toast.LENGTH_LONG
            ).show()

            else -> Unit
        }

    }
           Scaffold (
               topBar = {
                   TopAppBar(
                       title = { Text(text = "Don't have an account?",
                       modifier = Modifier.fillMaxWidth(),
                       style = TextStyle(
                       textAlign = TextAlign.End,
                   )) },
                        navigationIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "back"
                                )
                            }
                        },
                       actions = {
                           FilledTonalButton(onClick = {
                               navController.navigate("Signup")
                           },
                               modifier = Modifier.padding(horizontal = 8.dp)) {
                               Text("Get Started")
                           }
                       }

                   )
               }
           ){
               innerPadding ->
               Column (modifier = Modifier
                   .padding(innerPadding)
                   .fillMaxSize()
                   .padding(horizontal = 16.dp),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                  // Text("Ping Me", style = TextStyle(fontSize = 24.sp),)



                   Text(text = "Welcome Back", style =  TextStyle(
                       fontSize = 32.sp,
                       fontWeight = FontWeight.SemiBold, letterSpacing = 2.sp

                   ))
                   OutlinedTextField(

                       modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                       value = emailtext,
                       onValueChange = { emailtext = it },
                       label = { Text(text = "Email") },
                          placeholder = {
                              Text(text = "Enter your email here")
                          },
                       leadingIcon = {
                           Icon(
                               imageVector = Icons.Default.Email,
                               contentDescription = "email"
                           )
                       },
                   keyboardOptions = KeyboardOptions(
                       keyboardType = KeyboardType.Email,
                       imeAction = ImeAction.Next
                   )
                       //prefix = Icon(imageVector = Icons.Default.Email, contentDescription = "email")

                   )

                   Spacer(modifier = Modifier.height(10.dp))
                   OutlinedTextField(
                       modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                       value = passwordtext,
                       onValueChange = { passwordtext = it },
                       label = { Text(text = "Password") },
                       placeholder = {
                           Text(text = "Enter your password here")
                       },
                       leadingIcon = {
                           Icon(
                               imageVector = Icons.Default.CheckCircle,
                               contentDescription = "email"
                           )
                       },
                       keyboardOptions = KeyboardOptions(
                           keyboardType = KeyboardType.Password,
                           imeAction = ImeAction.Done
                       ),
                       trailingIcon = {
                         IconButton(onClick = {
                             showpassword = !showpassword
                         }) {
                             Icon(imageVector =  if (showpassword){
                                 Icons.Default.Favorite
                             } else {
                                 Icons.Default.FavoriteBorder
                             }, contentDescription = "email")
                         }
                       },
                       visualTransformation = if (showpassword){
                           VisualTransformation.None} else{
                               PasswordVisualTransformation()
                           }
                       //prefix = Icon(imageVector = Icons.Default.Email, contentDescription = "email")

                   )
                   Spacer(modifier = Modifier.height(10.dp))

                   FilledTonalButton(onClick = {
                       println("gn")
                      authviewmodel.login(emailtext,passwordtext)
                   }, modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 15.dp)) {
                       Text("Login",modifier = Modifier.padding(vertical = 10.dp))
                   }

                   Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp)) {


                       Text(text = "Sign in with Google", modifier = Modifier.padding(vertical = 10.dp))
                   }


               }
           }

}