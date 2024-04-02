package com.feature.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.core.common.extension.toStateFlow
import com.feature.auth.components.AuthComponent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable

class RealRootComponent @AssistedInject internal constructor(
    @Assisted
    componentContext: ComponentContext,
    private val authFactory: AuthComponent.Factory
) : ComponentContext by componentContext, RootComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack: StateFlow<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Authorization,
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    private fun createChild(
        childConfig: ChildConfig,
        componentContext: ComponentContext
    ): RootComponent.Child = when (childConfig) {
        is ChildConfig.Authorization -> RootComponent.Child.Authorization(
            authorizationComponent(
                componentContext
            )
        )
    }

    private fun authorizationComponent(componentContext: ComponentContext): AuthComponent =
        authFactory(
            componentContext,
            onHomeScreen = {

            }
        )

    @Serializable
    private sealed interface ChildConfig {
        @Serializable
        data object Authorization : ChildConfig
    }

    @AssistedFactory
    interface Factory: RootComponent.Factory {
        override fun invoke(componentContext: ComponentContext): RealRootComponent
    }
}