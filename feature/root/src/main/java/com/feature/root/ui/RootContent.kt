package com.feature.root.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.feature.auth.ui.AuthContent
import com.feature.root.component.RootComponent

@Composable
fun RootContent(component: RootComponent) {

    val childStack by component.childStack.collectAsState()

    Children(
        stack = childStack
    ) { child ->
        when(val instance = child.instance) {
            is RootComponent.Child.Authorization -> AuthContent(component = instance.component)
        }
    }
}
