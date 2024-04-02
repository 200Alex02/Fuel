package com.feature.start.components

import com.arkivanov.decompose.ComponentContext

interface StartComponent {

    fun onSignInClick()

    fun onSingUpClick()

    fun interface Factory {
        operator fun invoke (
            componentContext: ComponentContext,
            onSignInClick: () -> Unit,
            onSingUpClick: () -> Unit
        ): StartComponent
    }
}
