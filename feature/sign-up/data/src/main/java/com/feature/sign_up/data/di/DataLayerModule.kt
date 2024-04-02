package com.feature.sign_up.data.di

import com.feature.sign_up.data.repository.SignUpRepositoryImpl
import com.feature.sign_up.domain.repository.SignUpRepository
import dagger.Binds
import dagger.Module

@Module
interface DataLayerModule {

    @Binds
    fun singUpRepository(impl: SignUpRepositoryImpl): SignUpRepository
}