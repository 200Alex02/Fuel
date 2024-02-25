package com.feature.auth.components

import com.arkivanov.decompose.ComponentContext
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class RealStartComponent @AssistedInject internal constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted("onSignInClick") private val onSignInClick: () -> Unit,
    @Assisted("onSingUpClick") private val onSingUpClick: () -> Unit
): StartComponent, ComponentContext by componentContext {
    override fun onSignInClick() {
        onSignInClick.invoke()
    }

    override fun onSingUpClick() {
        onSingUpClick.invoke()
    }

    @AssistedFactory
    interface Factory: StartComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
            @Assisted("onSignInClick") onSignInClick: () -> Unit,
            @Assisted("onSingUpClick")onSingUpClick: () -> Unit
        ): StartComponent
    }
}
