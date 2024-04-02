package com.feature.auth.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.feature.sign_up.ui.components.SignUpComponent
import com.feature.start.components.StartComponent
import kotlinx.coroutines.flow.StateFlow

interface AuthComponent {

    val childStack: StateFlow<ChildStack<*, Child>>

    sealed class Child {
        class StartChild(val component: StartComponent): Child()
        class SignUpChild(val component: SignUpComponent): Child()
    }

    fun interface Factory {
        operator fun invoke (
            componentContext: ComponentContext,
            onHomeScreen: () -> Unit
        ): AuthComponent
    }
}