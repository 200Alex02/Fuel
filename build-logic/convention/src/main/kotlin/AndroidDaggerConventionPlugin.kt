import com.example.fuel.implementation
import com.example.fuel.kapt
import com.example.fuel.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidDaggerConventionPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.kapt")
            }

            dependencies {
                implementation(libs.findLibrary("dagger-dagger").get())
                kapt(libs.findLibrary("dagger-compiler").get())
            }
        }
    }

}