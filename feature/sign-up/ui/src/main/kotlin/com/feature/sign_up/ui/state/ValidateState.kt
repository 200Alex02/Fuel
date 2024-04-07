package com.feature.sign_up.ui.state

import com.core.common.util.UiText

data class ValidateState(
    val email: String = "",
    val errorEmail: UiText? = null,
    val password: String = "",
    val errorPassword: UiText? = null,
    val repeatedPassword: String = "",
    val errorRepeatedPassword: UiText? = null
)