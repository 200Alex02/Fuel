package com.feature.sign_up.domain.use_case

import com.core.common.util.Response
import com.feature.sign_up.domain.repository.SignUpRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class SignUpUseCase1 @Inject constructor(
    private val singUpRepository: SignUpRepository
) {

    operator fun invoke(email: String, password: String) = flow {
        try {
            emit(Response.Loading)
            val signUpResult = singUpRepository.signUpWithEmailAndPassword(email, password).await()
            emit(Response.Success(signUpResult))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage))
        }
    }
}