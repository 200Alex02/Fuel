import com.android.build.api.dsl.ApplicationExtension
import com.example.fuel.TARGET_SDK
import com.example.fuel.VERSION_CODE
import com.example.fuel.configureKotlinAndroid
import com.example.fuel.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure


class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(project.pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                configureDefaultConfig(
                    TARGET_SDK,
                    VERSION_CODE,
                    libs.findVersion("versionName").toString()
                )
            }
        }
    }
}

private fun ApplicationExtension.configureDefaultConfig(
    targetSdk: Int,
    versionCode: Int,
    versionName: String
) {
    defaultConfig {
        applicationId = "com.example.fuel"
        this.targetSdk = targetSdk
        this.versionCode = versionCode
        this.versionName = versionName

        vectorDrawables {
            useSupportLibrary = true
        }
    }
}