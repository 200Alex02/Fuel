
plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.library.compose)
}

android { namespace = "com.core.design_system" }

dependencies {

    implementation(projects.core.common)
}