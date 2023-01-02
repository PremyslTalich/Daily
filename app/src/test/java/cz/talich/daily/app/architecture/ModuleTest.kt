@file:Suppress("PropertyName", "VariableNaming", "HasPlatformType")

package cz.talich.daily.app.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchUnitRunner
import com.tngtech.archunit.library.Architectures.layeredArchitecture
import cz.talich.daily.app.architecture.ArchUnitFixtures.Modules.app
import cz.talich.daily.app.architecture.ArchUnitFixtures.Modules.feature
import cz.talich.daily.app.architecture.ArchUnitFixtures.Modules.library
import org.junit.runner.RunWith

@AnalyzeClasses(
    packages = ["cz.talich.daily"]
)
@RunWith(ArchUnitRunner::class)
internal class ModuleTest {
    @ArchTest
    val `module dependencies should obey the architecture rules` =
        layeredArchitecture().consideringAllDependencies().withOptionalLayers(true)
            .layer(app).definedBy("cz.talich.daily")
            .layer(feature).definedBy("cz.talich.daily.$feature")
            .layer(library).definedBy("cz.talich.daily.$library")
            .whereLayer(app).mayNotBeAccessedByAnyLayer()
            .whereLayer(feature).mayOnlyAccessLayers(library)
            .whereLayer(library).mayOnlyAccessLayers(library)
}
