package com.example.fuel.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.core.design_system.theme.AppTheme
import com.example.fuel.di.DaggerAppComponent
import com.feature.root.ui.RootContent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = DaggerAppComponent
            .factory()
            .create(applicationContext)

        val rootComponent = appComponent.rootComponentFactory(defaultComponentContext())

        setContent {
            AppTheme {
                RootContent(component = rootComponent)
            }
        }
    }
}



