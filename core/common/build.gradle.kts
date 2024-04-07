plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.library.compose)
}

android.namespace = "com.core.common"

dependencies {

    implementation(libs.arkivanov.decompose)
}