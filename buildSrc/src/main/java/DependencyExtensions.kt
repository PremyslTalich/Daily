import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.add(
    dependencies: List<Pair<String, String>>
) = dependencies.forEach { (implementationMethod, dependency) ->
    add(implementationMethod, dependency)
}

fun DependencyHandler.addModule(module: String) = add("implementation", project(module))
