@file:Suppress("PropertyName", "VariableNaming", "HasPlatformType")

package cz.talich.daily.app.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchUnitRunner
import com.tngtech.archunit.library.Architectures.layeredArchitecture
import org.junit.runner.RunWith

@AnalyzeClasses(
    packages = ["cz.talich.daily"]
)
@RunWith(ArchUnitRunner::class)
internal class ModuleTest {
    private val app = "App"
    private val appPackage = "cz.talich.daily"

    private val feature = "Feature"
    private val featurePackage = "cz.talich.daily.feature"

    private val library = "Library"
    private val libraryPackage = "cz.talich.daily.library"

    @ArchTest
    val `module dependencies should obey the architecture rules` =
        layeredArchitecture().consideringAllDependencies().withOptionalLayers(true)
            .layer(app).definedBy(appPackage)
            .layer(feature).definedBy(featurePackage)
            .layer(library).definedBy(libraryPackage)
            .whereLayer(app).mayNotBeAccessedByAnyLayer()
            .whereLayer(feature).mayOnlyBeAccessedByLayers(app)
            .whereLayer(feature).mayOnlyAccessLayers(library)
            .whereLayer(library).mayNotAccessAnyLayer()
}
