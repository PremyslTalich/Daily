import org.gradle.api.Project
import java.io.FileNotFoundException
import java.util.*

val Project.localProperties
    get() = try {
        Properties().apply {
            load(project.rootProject.file("local.properties").inputStream())
        }
    } catch (e: FileNotFoundException) {
        println(e)
        null
    }

val Project.moduleNamespace: String
    get() = "${Application.namespace}.${parent?.name}.${name}"
