package com.example.fuel

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fuel.ui.theme.FuelTheme
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {

    private val auth = FirebaseAuth.getInstance()
    private var authStatus: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FuelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "register"
                    ) {
                        composable("register") {
                            RegisterScreen(
                                navHostController = navController,
                                onSignUp = { email, password ->
                                    signUpWithEmailAnsPassword(email, password)
                                },
                                authState = authStatus)
                        }
                        composable("login") {
                            LoginEmailScreen { email, password ->
                                signInWithEmailAnsPassword(email, password)
                            }
                        }
                    }
                    /*LoginPhoneScreen { phoneNumber ->
                        sendOtp(phoneNumber)
                        Log.d("tag6", phoneNumber)
                    }*/

                }
            }
        }
    }

    private fun signInWithEmailAnsPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("tag8", "signInWithEmail:success")
                    val user = auth.currentUser
                    Log.d("tag8", user.toString())
                } else {
                    // If sign in fails, display a message to the user.
                    Log.d("tag8", "signInWithEmail:failure", task.exception)
                }
            }
    }

    private fun signUpWithEmailAnsPassword(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("tag7", "createUserWithEmail:success")
                    authStatus = true
                } else {
                    // If sign in fails, display a message to the user.
                    Log.d("tag7", "createUserWithEmail:failure", task.exception)
                }
            }
    }

    private fun sendOtp(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                    sigIn(p0)
                }

                override fun onVerificationFailed(p0: FirebaseException) {
                    Log.d("tag5", p0.message.toString())
                }

                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken,
                ) {
                    Log.d("tag5", "onCodeSent:$verificationId")
                }

            })
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun sigIn(phoneAuthCredential: PhoneAuthCredential) {
        //logic signIn to next screen
    }
}

@Composable
fun RegisterScreen(
    onSignUp: (String, String) -> Unit,
    navHostController: NavHostController,
    authState: Boolean
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val authStateCom by remember {
        mutableStateOf(authState)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            ),
            text = "Регистрация"
        )
        TextField(
            modifier = Modifier.padding(top = 15.dp),
            value = email,
            onValueChange = {
                email = it
            },
            label = { Text(text = "Введите email..") }
        )
        TextField(
            modifier = Modifier.padding(top = 10.dp),
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Введите password..") }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            onClick = {
                onSignUp(email, password)
                if (authStateCom) {
                    navHostController.navigate("login")
                }

            },
            content = {}
        )
    }
}

@Composable
fun LoginEmailScreen(
    onSignIn: (String, String) -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            ),
            text = "Вход"
        )
        TextField(
            modifier = Modifier.padding(top = 15.dp),
            value = email,
            onValueChange = {
                email = it
            },
            label = { Text(text = "Введите email..") }
        )
        TextField(
            modifier = Modifier.padding(top = 10.dp),
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Введите password..") }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            onClick = {
                onSignIn(email, password)

            },
            content = {}
        )
    }
}

@Composable
fun LoginPhoneScreen(
    onSignIn: (String) -> Unit
) {
    var phoneNumber by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    var showCodeInput by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Номер телефона") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (!showCodeInput) {
            Button(
                onClick = {
                    showCodeInput = true
                    onSignIn(phoneNumber)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Получить код")
            }
        } else {
            OutlinedTextField(
                value = code,
                onValueChange = { code = it },
                label = { Text("Код") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Далее")
            }
        }
    }
}



