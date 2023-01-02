package cz.talich.daily.app.architecture

internal object ArchUnitFixtures {
    const val packages = "cz.talich.daily"
    const val extensionsNameSuffix = "ExtensionsKt"

    object Layers {
        const val system = "system"
        const val data = "data"
        const val presentation = "presentation"
        const val device = "device"
        const val domain = "domain"
        const val model = "model"
        const val infrastructure = "infrastructure"
        const val di = "di"
    }

    object Modules {
        const val app = "system"
        const val feature = "data"
        const val library = "presentation"
    }
}
