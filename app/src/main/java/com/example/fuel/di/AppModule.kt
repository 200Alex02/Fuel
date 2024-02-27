package com.example.fuel.di

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideFireBaseAuth(): FirebaseAuth {
        return Firebase.auth
    }
}