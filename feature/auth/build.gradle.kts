@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.dagger)
    alias(libs.plugins.common.android.library.compose)
    alias(libs.plugins.kotlin.serialization)
}
android.namespace = "com.feature.auth"

dependencies {

    implementation(projects.core.common)
    implementation(projects.feature.signUp.ui)
    implementation(projects.feature.start)

    implementation(libs.arkivanov.decompose)
    implementation(libs.arkivanov.decompose.extensionsCompose)
    implementation(libs.core.ktx)
}