package com.feature.sign_up.ui.components

import com.arkivanov.decompose.ComponentContext
import com.core.common.extension.componentCoroutineScope
import com.core.common.util.Response
import com.feature.sign_up.domain.use_case.SignUpUseCase
import com.feature.sign_up.ui.state.SignUpState
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class RealSignUpComponent @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted("onSignUpClick")
    private val onSignUpClick: () -> Unit,
    @Assisted("onBackClick")
    private val onBackClick: () -> Unit,
    private val signUpUseCase: SignUpUseCase
) : SignUpComponent, ComponentContext by componentContext {

    private val coroutineScope = componentCoroutineScope()

    override val signUpState = MutableStateFlow(SignUpState())

    override val email = MutableStateFlow("")

    override val password = MutableStateFlow("")

    override val repeatedPassword = MutableStateFlow("")

    override fun onEmailChanged(email: String) {
        this.email.value = email
    }

    override fun onPasswordChanged(password: String) {
        this.password.value = password
    }

    override fun onRepeatedPasswordChanged(repeatedPassword: String) {
        this.repeatedPassword.value = repeatedPassword
    }

    override fun onSignUpClick() {
        onSignUpClick.invoke()
    }

    override fun onBackClick() {
        onBackClick.invoke()
    }

    fun signUpWithEmailAndPassword() {
        signUpUseCase(email.value, password.value)
            .onEach { result ->
                when (result) {
                    is Response.Loading -> {
                        signUpState.update { it.copy(isLoading = true) }
                    }

                    is Response.Error -> {
                        signUpState.update { it.copy(error = result.errorMessage ?: "") }
                    }

                    is Response.Success -> {
                        signUpState.update { it.copy(isLoading = false, success = true) }
                    }
                }
            }.launchIn(coroutineScope)
    }
}