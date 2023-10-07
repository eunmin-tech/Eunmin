import org.gradle.api.Plugin
import org.gradle.api.Project

class ApplicationSafeArgsConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("androidx.navigation.safeargs.kotlin")
            }
        }
    }
}