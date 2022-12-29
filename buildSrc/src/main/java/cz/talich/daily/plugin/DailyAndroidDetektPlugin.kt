package cz.talich.daily.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class DailyAndroidDetektPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configurePlugins()
    }
}

private fun Project.configurePlugins() {
    plugins.apply("io.gitlab.arturbosch.detekt")
}
