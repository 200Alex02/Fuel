package com.feature.auth.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.feature.auth.components.AuthComponent
import com.feature.sign_up.ui.ui.SignUpContent
import com.feature.start.ui.StartContent

@Composable
fun AuthContent(component: AuthComponent) {
    val childStack by component.childStack.collectAsState()

    Children(
        stack = childStack
    ) { child ->
        when (val instance = child.instance) {
            is AuthComponent.Child.StartChild -> StartContent(component = instance.component)
            is AuthComponent.Child.SignUpChild -> SignUpContent(component = instance.component)
        }
    }
}