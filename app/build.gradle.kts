plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    kotlin("kapt")
}

android {
    namespace = "com.example.fuel"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.appId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.core)
    implementation(Dependencies.lifecycle)
    implementation(JetpackCompose.activity)
    implementation(platform(JetpackCompose.composeBom))
    implementation(JetpackCompose.ui)
    implementation(JetpackCompose.uiGraphics)
    implementation(JetpackCompose.toolingPreview)
    implementation(JetpackCompose.composeMaterial)

    implementation("com.google.firebase:firebase-auth:22.3.1")

    testImplementation(Junit.junit)
    androidTestImplementation(Test.testJunit)
    androidTestImplementation(Test.espresso)
    androidTestImplementation(platform(JetpackCompose.composeBom))
    androidTestImplementation(JetpackCompose.composeTest)
    debugImplementation(JetpackCompose.uiTooling)
    debugImplementation(JetpackCompose.manifestCompose)
    implementation(platform(FireBase.firebaseBom))
    implementation(FireBase.firebaseAnalytics)
    implementation(FireBase.firebaseAuth)
}