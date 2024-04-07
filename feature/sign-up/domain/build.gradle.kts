plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.dagger)
}
android.namespace = "com.feature.sign_up.domain"

dependencies {

    implementation(projects.core.common)

    implementation(libs.kotlinx.coroutines)
    implementation(libs.firebase.auth)
}