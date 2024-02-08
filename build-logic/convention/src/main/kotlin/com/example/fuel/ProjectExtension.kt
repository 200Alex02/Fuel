package com.example.fuel

import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

internal fun Project.version(key: String): String = extensions
    .getByType<VersionCatalogsExtension>()
    .named("libs")
    .findVersion(key)
    .get()
    .requiredVersion

internal fun Project.versionInt(key: String) = version(key).toInt()

internal val Project.COMPILE_SDK get() = versionInt("compileSdk")
internal val Project.MIN_SDK get() = versionInt("minSdk")
internal val Project.TARGET_SDK get() = versionInt("targetSdk")
internal val Project.VERSION_CODE get() = versionInt("versionCode")

val Project.libs
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun DependencyHandler.implementation(dependencyNotation: Provider<MinimalExternalModuleDependency>) {
    add("implementation", dependencyNotation)
}

fun DependencyHandler.debugImplementation(dependencyNotation: Provider<MinimalExternalModuleDependency>) {
    add("debugImplementation", dependencyNotation)
}

fun DependencyHandler.kapt(dependencyNotation: Provider<MinimalExternalModuleDependency>) {
    add("kapt", dependencyNotation)
}

fun Project.library(alias: String): Provider<MinimalExternalModuleDependency> {
    return libs.findLibrary(alias).get()
}