package com.example.fuel.di

import android.content.Context
import com.feature.root.component.RealRootComponent
import com.feature.root.di.RootModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RootModule::class
    ]
)
interface AppComponent {

    val rootComponentFactory: RealRootComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}