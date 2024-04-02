package com.feature.sign_up.domain.di

import com.feature.sign_up.domain.repository.SignUpRepository
import com.feature.sign_up.domain.use_case.SignUpUseCase1
import dagger.Module
import dagger.Provides

@Module
class DomainLayerModule {

   @Provides
   fun provideSignUpUseCase(signUpRepository: SignUpRepository): SignUpUseCase1 {
       return SignUpUseCase1(signUpRepository)
   }
}
