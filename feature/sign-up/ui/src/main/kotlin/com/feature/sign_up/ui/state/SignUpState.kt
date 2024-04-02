package com.feature.sign_up.ui.state

data class SignUpState (
    val success: Boolean = false,
    val error: String = "",
    val isLoading: Boolean = false,
)