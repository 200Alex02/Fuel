package com.feature.sign_up.domain.use_case

import com.core.common.extension.isValidEmail
import com.core.common.util.UiText
import com.feature.sign_up.domain.R
import com.feature.sign_up.domain.model.ValidationResult
import javax.inject.Inject

class ValidateEmailUseCase @Inject constructor() {

    fun execute(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strTheEmailCanNotBeBlank)
            )
        }

        if (!email.isValidEmail()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strThatsNotAValidEmail)
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}