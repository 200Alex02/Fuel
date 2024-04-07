package com.feature.sign_up.ui.state

sealed class ValidateEvent {
    data class EmailChanged(val email: String) : ValidateEvent()
    data class PasswordChanged(val password: String) : ValidateEvent()
    data class RepeatedPasswordChanged(val repeatedPassword: String) : ValidateEvent()
    data object Submit : ValidateEvent()
}