package com.feature.sign_up.domain.di

import com.feature.sign_up.domain.repository.SignUpRepository
import com.feature.sign_up.domain.use_case.SignUpUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainLayerModule {

   @Provides
   fun provideSignUpUseCase(signUpRepository: SignUpRepository): SignUpUseCase {
       return SignUpUseCase(signUpRepository)
   }
}
