@file:Suppress("PropertyName", "VariableNaming", "HasPlatformType")

package cz.talich.daily.app.architecture.presentation

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchUnitRunner
import cz.talich.daily.app.architecture.ArchUnitFixtures
import cz.talich.daily.app.architecture.ArchUnitFixtures.extensionsNameSuffix
import cz.talich.daily.app.architecture.DoNotIncludeTests
import cz.talich.daily.app.architecture.haveSimpleNameEndingWithOrWrapper
import cz.talich.daily.app.architecture.presentation.PresentationLayerFixtures.presentationLayerClasses
import cz.talich.daily.app.architecture.presentation.PresentationLayerFixtures.viewModelNameSuffix
import org.junit.runner.RunWith


@AnalyzeClasses(
    packages = [ArchUnitFixtures.packages],
    importOptions = [DoNotIncludeTests::class]
)
@RunWith(ArchUnitRunner::class)
internal class PresentationLayerTest {
    @ArchTest
    val `presentation layer should only contain classes with permitted name` =
        presentationLayerClasses
            .should()
            .haveSimpleNameEndingWithOrWrapper(viewModelNameSuffix)
            .orShould()
            .haveSimpleNameEndingWith(extensionsNameSuffix)
}
