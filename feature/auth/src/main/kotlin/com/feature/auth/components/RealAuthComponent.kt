package com.feature.auth.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.core.common.extension.toStateFlow
import com.feature.sign_up.ui.components.SignUpComponent
import com.feature.start.components.StartComponent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable

class RealAuthComponent @AssistedInject internal constructor(
    private val startFactory: StartComponent.Factory,
    private val signUpFactory: SignUpComponent.Factory,
    @Assisted("onHomeScreen") private val onHomeScreen: () -> Unit,
    @Assisted componentContext: ComponentContext
) : AuthComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack: StateFlow<ChildStack<*, AuthComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = ChildConfig.Start,
            serializer = ChildConfig.serializer(),
            handleBackButton = true,
            childFactory = ::child
        ).toStateFlow(lifecycle)

    private fun child(
        childConfig: ChildConfig,
        componentContext: ComponentContext
    ): AuthComponent.Child =
        when (childConfig) {
            is ChildConfig.Start -> AuthComponent.Child.StartChild(startComponent(componentContext))
            is ChildConfig.SignUp -> AuthComponent.Child.SignUpChild(
                signUpComponent(
                    componentContext
                )
            )
        }

    @OptIn(ExperimentalDecomposeApi::class)
    private fun startComponent(componentContext: ComponentContext): StartComponent =
        startFactory(
            componentContext,
            onSignInClick = {

            },
            onSingUpClick = {
                navigation.pushNew(ChildConfig.SignUp)
            }
        )

    private fun signUpComponent(componentContext: ComponentContext): SignUpComponent =
        signUpFactory(
            componentContext,
            onSignUpClick = {
                onHomeScreen()
            },
            onBackClick = navigation::pop,
            onSignInClick = {

            }
        )

    @Serializable
    private sealed interface ChildConfig {
        @Serializable
        data object Start : ChildConfig

        @Serializable
        data object SignUp : ChildConfig
    }

    @AssistedFactory
    interface Factory: AuthComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
            @Assisted("onHomeScreen") onHomeScreen: () -> Unit
        ): RealAuthComponent
    }
}