package com.feature.sign_up.ui.components

import com.feature.sign_up.ui.state.SignUpState
import kotlinx.coroutines.flow.MutableStateFlow

class FakeSignUpComponent : SignUpComponent {

    override val signUpState = MutableStateFlow(SignUpState())

    override val email = MutableStateFlow("email")
    override val password = MutableStateFlow("password")
    override val repeatedPassword = MutableStateFlow("repeatedPassword")

    override fun onEmailChanged(email: String) = Unit

    override fun onPasswordChanged(password: String) = Unit

    override fun onRepeatedPasswordChanged(repeatedPassword: String) = Unit

    override fun onSignUpClick() = Unit

    override fun onBackClick() = Unit
}