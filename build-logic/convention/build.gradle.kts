plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibraryComposeConventionPlugin") {
            id = "fuel.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidApplicationComposeConventionPlugin")  {
            id = "fuel.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplicationConventionPlugin") {
            id = "fuel.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryConventionPlugin") {
            id = "fuel.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidDaggerConventionPlugin") {
            id = "fuel.android.dagger"
            implementationClass = "AndroidDaggerConventionPlugin"
        }
    }
}