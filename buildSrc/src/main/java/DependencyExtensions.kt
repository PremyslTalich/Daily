import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.add(
    dependencies: List<Pair<String, String>>
) = dependencies.forEach { (implementationMethod, dependency) ->
    add(implementationMethod, dependency)
}