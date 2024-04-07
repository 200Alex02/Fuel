package com.feature.sign_up.ui.components

import com.feature.sign_up.ui.state.SignUpState
import com.feature.sign_up.ui.state.ValidateEvent
import com.feature.sign_up.ui.state.ValidateState
import kotlinx.coroutines.flow.MutableStateFlow

class FakeSignUpComponent : SignUpComponent {

    override val signUpState = MutableStateFlow(SignUpState())
    override val formState = MutableStateFlow(ValidateState())

    override fun onEvent(event: ValidateEvent) {}

    override fun onSignUpClick() = Unit
    override fun onSignInClick() = Unit

    override fun onBackClick() = Unit
}