@file:Suppress("PropertyName", "VariableNaming", "HasPlatformType")

package cz.talich.daily.app.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchUnitRunner
import com.tngtech.archunit.library.Architectures.layeredArchitecture
import cz.talich.daily.app.architecture.ArchUnitFixtures.Layers.data
import cz.talich.daily.app.architecture.ArchUnitFixtures.Layers.device
import cz.talich.daily.app.architecture.ArchUnitFixtures.Layers.di
import cz.talich.daily.app.architecture.ArchUnitFixtures.Layers.domain
import cz.talich.daily.app.architecture.ArchUnitFixtures.Layers.infrastructure
import cz.talich.daily.app.architecture.ArchUnitFixtures.Layers.model
import cz.talich.daily.app.architecture.ArchUnitFixtures.Layers.presentation
import cz.talich.daily.app.architecture.ArchUnitFixtures.Layers.system
import org.junit.runner.RunWith

@AnalyzeClasses(
    packages = ["cz.talich.daily"]
)
@RunWith(ArchUnitRunner::class)
internal class LayerTest {
    @ArchTest
    val `layer dependencies should obey the architecture rules` =
        layeredArchitecture().consideringAllDependencies().withOptionalLayers(true)
            .layer(system).definedBy("..$system")
            .layer(data).definedBy("..$data")
            .layer(presentation).definedBy("..$presentation")
            .layer(device).definedBy("..$device")
            .layer(domain).definedBy("..$domain")
            .layer(model).definedBy("..$model")
            .layer(infrastructure).definedBy("..$infrastructure")
            .layer(di).definedBy("..$di")
            .whereLayer(di).mayOnlyBeAccessedByLayers(system)
            .whereLayer(infrastructure).mayOnlyBeAccessedByLayers(di, system, data, device, presentation, domain, model)
            .whereLayer(model).mayOnlyBeAccessedByLayers(di, system, data, device, presentation, domain)
            .whereLayer(domain).mayOnlyBeAccessedByLayers(data, presentation, device)
            .whereLayer(data).mayOnlyBeAccessedByLayers(system)
            .whereLayer(presentation).mayOnlyBeAccessedByLayers(system)
            .whereLayer(device).mayOnlyBeAccessedByLayers(system)
            .whereLayer(system).mayOnlyBeAccessedByLayers(di)
}
