import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Version {
    const val core = "1.12.0"
    const val lifecycle = "2.7.0"

    //    Compose
    const val activity = "1.8.2"
    const val composeUi = "ui"
    const val uiGraphics = "ui-graphics"
    const val toolingPreview = "ui-tooling-preview"
    const val composeBom = "2023.08.00"
    const val composeMaterial = "material3"
    const val composeTest = "ui-test-junit4"
    const val uiTooling = "ui-tooling"
    const val manifestCompose = "ui-test-manifest"

    //    TestJunit
    const val junit = "4.13.2"

    //    Test
    const val testJunit = "1.1.5"
    const val espresso = "3.5.1"

    //    FireBase
    const val firebaseBom = "32.7.1"
    const val firebaseAnalytics = "firebase-analytics"
    const val firebaseAuth = "firebase-auth-ktx"

    //    Hilt
    const val hilt = "2.45"

}

object FireBase {
    const val firebaseBom = "com.google.firebase:firebase-bom:${Version.firebaseBom}"
    const val firebaseAnalytics = "com.google.firebase:${Version.firebaseAnalytics}"
    const val firebaseAuth = "com.google.firebase:${Version.firebaseAuth}"
}

object Dependencies {
    const val core = "androidx.core:core-ktx:${Version.core}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
}

object JetpackCompose {
    const val activity = "androidx.activity:activity-compose:${Version.activity}"
    const val ui = "androidx.compose.ui:${Version.composeUi}"
    const val uiGraphics = "androidx.compose.ui:${Version.uiGraphics}"
    const val toolingPreview = "androidx.compose.ui:${Version.toolingPreview}"
    const val composeBom = "androidx.compose:compose-bom:${Version.composeBom}"
    const val composeMaterial = "androidx.compose.material3:${Version.composeMaterial}"
    const val composeTest = "androidx.compose.ui:${Version.composeTest}"
    const val uiTooling = "androidx.compose.ui:${Version.uiTooling}"
    const val manifestCompose = "androidx.compose.ui:${Version.manifestCompose}"
}

object Junit {
    const val junit = "junit:junit:${Version.junit}"
}

object Test {
    const val testJunit = "androidx.test.ext:junit:${Version.testJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
}

object Hilt {
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
}

fun DependencyHandler.compose() {
    implementation(JetpackCompose.activity)
    implementation(JetpackCompose.ui)
    implementation(JetpackCompose.uiGraphics)
    implementation(JetpackCompose.toolingPreview)
    implementation(JetpackCompose.composeBom)
    implementation(JetpackCompose.composeMaterial)
    implementation(JetpackCompose.uiTooling)
    implementation(JetpackCompose.manifestCompose)
}

fun DependencyHandler.fireBase() {
    implementation(FireBase.firebaseBom)
    implementation(FireBase.firebaseAuth)
    implementation(FireBase.firebaseAnalytics)
}

fun DependencyHandler.retrofit() {

}

fun DependencyHandler.hilt() {

}

fun DependencyHandler.feature() {
    implementation(project(":feature"))
}

fun DependencyHandler.core() {
    implementation(project(":core"))
}

fun DependencyHandler.test() {
    implementation(project(":feature:profile"))
}



