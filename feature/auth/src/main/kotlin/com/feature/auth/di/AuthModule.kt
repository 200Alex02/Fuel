package com.feature.auth.di

import com.feature.auth.components.AuthComponent
import com.feature.auth.components.RealAuthComponent
import dagger.Binds
import dagger.Module

@Module
interface AuthModule {

    @Binds
    fun authComponentFactory(impl: RealAuthComponent.Factory): AuthComponent.Factory
}