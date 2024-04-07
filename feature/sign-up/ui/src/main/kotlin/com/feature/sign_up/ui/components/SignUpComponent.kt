package com.feature.sign_up.ui.components

import com.arkivanov.decompose.ComponentContext
import com.feature.sign_up.ui.state.SignUpState
import com.feature.sign_up.ui.state.ValidateEvent
import com.feature.sign_up.ui.state.ValidateState
import kotlinx.coroutines.flow.StateFlow

interface SignUpComponent {

    val signUpState: StateFlow<SignUpState>

    val formState: StateFlow<ValidateState>

    fun onEvent(event: ValidateEvent)

    fun onSignUpClick()

    fun onSignInClick()

    fun onBackClick()

    fun interface Factory {

        operator fun invoke(
            componentContext: ComponentContext,
            onSignUpClick: () -> Unit,
            onBackClick: () -> Unit,
            onSignInClick: () -> Unit
        ): SignUpComponent
    }
}