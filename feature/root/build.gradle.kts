@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.library.compose)
    alias(libs.plugins.common.android.dagger)
    alias(libs.plugins.kotlin.serialization)
}

android.namespace = "com.feature.root"

dependencies {
    implementation(projects.feature.auth)
    implementation(projects.feature.signUp.ui)
    implementation(projects.feature.start)
    implementation(projects.core.common)

    implementation(libs.arkivanov.decompose.extensionsCompose)
    implementation(libs.arkivanov.decompose)

    implementation(libs.core.ktx)
}