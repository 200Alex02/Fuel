
plugins {
    alias(libs.plugins.common.android.application)
    alias(libs.plugins.common.android.application.compose)
    alias(libs.plugins.google.services)
    alias(libs.plugins.common.android.dagger)
}

android {
    namespace = "com.example.fuel"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.core.designSystem)
    implementation(projects.feature.root)
    implementation(projects.feature.auth)
    implementation(projects.feature.signUp.ui)
    implementation(projects.feature.signUp.data)
    implementation(projects.feature.signUp.domain)
    implementation(projects.feature.start)

    implementation(libs.arkivanov.decompose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
    implementation(libs.firebase.analytics)
}