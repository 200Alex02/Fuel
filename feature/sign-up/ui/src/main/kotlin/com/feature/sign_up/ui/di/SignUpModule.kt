package com.feature.sign_up.ui.di

import com.feature.sign_up.data.di.DataLayerModule
import com.feature.sign_up.domain.di.DomainLayerModule
import com.feature.sign_up.ui.components.RealSignUpComponent
import com.feature.sign_up.ui.components.SignUpComponent
import dagger.Binds
import dagger.Module

@Module(includes = [DataLayerModule::class, DomainLayerModule::class])
interface SignUpModule {
    
    @Binds
    fun componentFactory(impl: RealSignUpComponent.Factory): SignUpComponent.Factory
}