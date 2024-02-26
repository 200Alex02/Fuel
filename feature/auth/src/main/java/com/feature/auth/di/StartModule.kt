package com.feature.auth.di

import com.feature.auth.components.StartComponent
import com.feature.auth.components.RealStartComponent
import dagger.Binds
import dagger.Module

@Module
interface StartModule {

    @Binds
    fun startComponentFactory(impl: RealStartComponent.Factory): StartComponent.Factory
}
