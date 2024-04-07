package com.feature.sign_up.domain.model

import com.core.common.util.UiText

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: UiText? = null
)
