package com.example.fuel

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {

        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("kotlinCompilerExtension").get().toString()
        }
    }

    dependencies {
        val composeBom = libs.findLibrary("androidx.compose.bom").get()
        implementation(platform(composeBom))
        implementation(libs.findLibrary("androidx.compose.ui").get())
        debugImplementation(libs.findLibrary("androidx.compose.toolingPreview").get())
        implementation(libs.findLibrary("androidx.compose.material3").get())
        implementation(libs.findLibrary("androidx.compose.tooling").get())
    }

}