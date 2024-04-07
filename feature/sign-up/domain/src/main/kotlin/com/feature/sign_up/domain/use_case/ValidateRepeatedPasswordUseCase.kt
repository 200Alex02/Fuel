package com.feature.sign_up.domain.use_case

import com.core.common.extension.isPasswordMatches
import com.core.common.util.UiText
import com.feature.sign_up.domain.R
import com.feature.sign_up.domain.model.ValidationResult
import javax.inject.Inject

class ValidateRepeatedPasswordUseCase @Inject constructor() {

    fun execute(password: String, repeatedPassword: String): ValidationResult {
        if (repeatedPassword.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strTheRepeatedPasswordCanNotBeBlank)
            )
        }

        if (!password.isPasswordMatches(repeatedPassword)) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strThatsNotAValidRepeatedPassword)
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}