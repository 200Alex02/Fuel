package com.feature.root.di

import com.feature.auth.di.AuthModule
import com.feature.root.component.RealRootComponent
import com.feature.root.component.RootComponent
import com.feature.sign_up.ui.di.SignUpModule
import com.feature.start.di.StartModule
import dagger.Binds
import dagger.Module

@Module(includes = [SignUpModule::class, StartModule::class, AuthModule::class])
interface RootModule {

    @Binds
    fun rootFactory(impl: RealRootComponent.Factory): RootComponent.Factory
}