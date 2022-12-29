package cz.talich.daily.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.kotlin.dsl.register

class DailyDependencyGraphPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configurePlugins()
        project.configureTasks()
    }
}

private fun Project.configurePlugins() {
    plugins.apply("com.vanniktech.dependency.graph.generator")
}

private fun Project.configureTasks() {
    tasks.register("generateAndCopyDependencyGraphs", Copy::class) {
        group = "reporting"
        dependsOn("generateProjectDependencyGraph", "generateDependencyGraph")

        from(
            "build/reports/project-dependency-graph/project-dependency-graph.png",
            "build/reports/dependency-graph/dependency-graph.png"
        )
        into("${rootProject.projectDir}/dependency graphs")
    }
}
