package com.feature.sign_up.ui.components

import com.arkivanov.decompose.ComponentContext
import com.feature.sign_up.ui.state.SignUpState
import kotlinx.coroutines.flow.StateFlow

interface SignUpComponent {

    val signUpState: StateFlow<SignUpState>

    val email: StateFlow<String>

    val password: StateFlow<String>

    val repeatedPassword: StateFlow<String>

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

    fun onRepeatedPasswordChanged(repeatedPassword: String)

    fun onSignUpClick()

    fun onBackClick()

    fun signUpWithEmailAndPassword()

    fun interface Factory {

        operator fun invoke(
            componentContext: ComponentContext,
            onSignUpClick: () -> Unit,
            onBackClick: () -> Unit
        ): SignUpComponent
    }
}