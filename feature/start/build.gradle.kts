@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.library.compose)
    alias(libs.plugins.common.android.dagger)
    alias(libs.plugins.kotlin.serialization)
}

android.namespace = "com.feature.auth"

dependencies {

    implementation(projects.core.designSystem)

    implementation(libs.arkivanov.decompose.extensionsCompose)
    implementation(libs.arkivanov.decompose)

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}