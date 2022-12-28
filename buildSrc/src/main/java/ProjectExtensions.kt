import org.gradle.api.Project
import java.util.*

val Project.localProperties
    get() = Properties().apply {
        load(
            project.rootProject.file("local.properties").inputStream()
        )
    }

val Project.moduleNamespace: String
    get() = "${Application.namespace}.${parent?.name}.${name}"
