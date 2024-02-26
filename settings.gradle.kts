pluginManagement {
    repositories {
        includeBuild("build-logic")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Fuel"
include(":app")
include(":feature:map:data")
include(":feature:map:domain")
include(":feature:map:ui")
include(":feature:profile:data")
include(":feature:profile:domain")
include(":feature:profile:ui")
include(":core:network")
include(":core:common")
include(":core:feature_api")
include(":core:design-system")
include(":feature:auth")
