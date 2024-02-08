package com.example.fuel

import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

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