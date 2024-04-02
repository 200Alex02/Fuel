package com.feature.start.di

import com.feature.start.components.StartComponent
import com.feature.start.components.RealStartComponent
import dagger.Binds
import dagger.Module

@Module
interface StartModule {

    @Binds
    fun startComponentFactory(impl: RealStartComponent.Factory): StartComponent.Factory
}
