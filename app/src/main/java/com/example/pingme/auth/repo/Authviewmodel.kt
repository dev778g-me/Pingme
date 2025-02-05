package com.example.pingme.auth.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class Authviewmodel  : ViewModel(){
    private val auth : FirebaseAuth = FirebaseAuth.getInstance()

private  val _authState = MutableLiveData<Authstate>()

    val  authstate : LiveData<Authstate> = _authState
init {
    Checkauthentication()
}
    fun Checkauthentication(){
        if(auth.currentUser == null){
            _authState.value = Authstate.unauthenticated
        } else{
            _authState.value = Authstate.authenticated
        }

        }


    fun login(email: String, password: String) {
        if (email.isEmpty() ||password.isEmpty()){
            _authState.value = Authstate.Error("Please fill all fields")
            return
        }else if (
            email.isEmpty() && password.isNotEmpty()
        ){
            _authState.value = Authstate.Error ("Please fill your Email address")
        }else if (email.isNotEmpty() && password.isEmpty()){
            _authState.value = Authstate.Error ("Please fill your Password")
        }
        _authState.value = Authstate.loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = Authstate.authenticated
                } else if (task.isCanceled) {
                    _authState.value = Authstate.authenticated
                } else{
                    _authState.value =
                        Authstate.Error(task.exception?.message ?: "Somethinng went wrong")
                }
            }
    }

    fun signup(email: String, password: String) {
        if (email.isEmpty() ||password.isEmpty()){
            _authState.value = Authstate.Error("Somethinng went wrong")
            return
        }
        _authState.value = Authstate.loading
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = Authstate.authenticated
                } else if (task.isCanceled) {
                    _authState.value = Authstate.authenticated
                } else{
                    _authState.value =
                        Authstate.Error(task.exception?.message ?: "Somethinng went wrong")
                }
            }
    }


    fun signout(){
        auth.signOut()
        _authState.value = Authstate.unauthenticated
    }
}


sealed class Authstate {
    object authenticated : Authstate()
    object  unauthenticated : Authstate()
    object  loading : Authstate()
    data class Error (val message : String) : Authstate()
}