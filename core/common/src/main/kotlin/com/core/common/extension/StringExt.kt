package com.core.common.extension

import android.util.Patterns

fun String.isValidEmail(): Boolean {
    return this.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    return this.isNotBlank()
}

fun String.isPasswordMatches(repeatedPassword: String): Boolean {
    return this == repeatedPassword
}