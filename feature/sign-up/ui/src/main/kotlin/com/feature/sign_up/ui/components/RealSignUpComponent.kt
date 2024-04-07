package com.feature.sign_up.ui.components

import com.arkivanov.decompose.ComponentContext
import com.core.common.extension.componentCoroutineScope
import com.core.common.util.Response
import com.feature.sign_up.domain.use_case.SignUpUseCase
import com.feature.sign_up.domain.use_case.ValidateEmailUseCase
import com.feature.sign_up.domain.use_case.ValidatePasswordUseCase
import com.feature.sign_up.domain.use_case.ValidateRepeatedPasswordUseCase
import com.feature.sign_up.ui.state.SignUpState
import com.feature.sign_up.ui.state.ValidateEvent
import com.feature.sign_up.ui.state.ValidateState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class RealSignUpComponent @AssistedInject internal constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted("onSignUpClick")
    private val onSignUpClick: () -> Unit,
    @Assisted("onBackClick")
    private val onBackClick: () -> Unit,
    @Assisted("onSignInClick")
    private val onSignInClick: () -> Unit,
    private val signUpUseCase: SignUpUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val validateRepeatedPasswordUseCase: ValidateRepeatedPasswordUseCase
) : SignUpComponent, ComponentContext by componentContext {

    private val coroutineScope = componentCoroutineScope()

    override val signUpState = MutableStateFlow(SignUpState())

    override val formState = MutableStateFlow(ValidateState())

    override fun onEvent(event: ValidateEvent) {
        when (event) {
            is ValidateEvent.EmailChanged -> {
                formState.update { it.copy(email = event.email) }
                validEmail()
            }

            is ValidateEvent.PasswordChanged -> {
                formState.update { it.copy(password = event.password) }
                validPassword()
            }

            is ValidateEvent.RepeatedPasswordChanged -> {
                formState.update { it.copy(repeatedPassword = event.repeatedPassword) }
                validRepeatedPassword()
            }

            is ValidateEvent.Submit -> {
                if (validEmail() && validPassword() && validRepeatedPassword()) {
                    signUpWithEmailAndPassword()
                }
            }
        }
    }

    private fun validEmail(): Boolean {
        val emailResult = validateEmailUseCase.execute(formState.value.email)
        formState.update { it.copy(errorEmail = emailResult.errorMessage) }
        return emailResult.successful
    }

    private fun validPassword(): Boolean {
        val passwordResult = validatePasswordUseCase.execute(formState.value.password)
        formState.update { it.copy(errorPassword = passwordResult.errorMessage) }
        return passwordResult.successful
    }

    private fun validRepeatedPassword(): Boolean {
        val repeatedPasswordResult = validateRepeatedPasswordUseCase.execute(
            password = formState.value.password,
            repeatedPassword = formState.value.repeatedPassword
        )
        formState.update { it.copy(errorRepeatedPassword = repeatedPasswordResult.errorMessage) }
        return repeatedPasswordResult.successful
    }

    override fun onSignUpClick() {
        onSignUpClick.invoke()
    }

    override fun onSignInClick() {
        onSignInClick.invoke()
    }

    override fun onBackClick() {
        onBackClick.invoke()
    }

    private fun signUpWithEmailAndPassword() {
        signUpUseCase(email = formState.value.email, password = formState.value.password)
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
                        onSignInClick.invoke()
                    }
                }
            }.launchIn(coroutineScope)
    }

    @AssistedFactory
    interface Factory : SignUpComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
            @Assisted("onSignUpClick") onSignUpClick: () -> Unit,
            @Assisted("onBackClick") onBackClick: () -> Unit,
            @Assisted("onSignInClick") onSignInClick: () -> Unit
        ): RealSignUpComponent
    }
}