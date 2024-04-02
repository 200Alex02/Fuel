package com.feature.sign_up.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult


interface SignUpRepository  {

    suspend fun signUpWithEmailAndPassword(email: String, password: String): Task<AuthResult>
}