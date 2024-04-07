package com.feature.sign_up.domain.use_case

import com.core.common.extension.isValidPassword
import com.core.common.util.UiText
import com.feature.sign_up.domain.R
import com.feature.sign_up.domain.model.ValidationResult
import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor() {

    fun execute(password: String): ValidationResult {
        if (password.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strThePasswordCanNotBeBlank)
            )
        }

        if (!password.isValidPassword()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strThatsNotAValidPassword)
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}