@file:Suppress("PropertyName", "VariableNaming", "HasPlatformType")

package cz.talich.daily.app.architecture.system

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchUnitRunner
import cz.talich.daily.app.architecture.ArchUnitFixtures
import cz.talich.daily.app.architecture.DoNotIncludeTests
import cz.talich.daily.app.architecture.haveSimpleNameEndingWithOrWrapper
import org.junit.runner.RunWith

@AnalyzeClasses(
    packages = [ArchUnitFixtures.packages],
    importOptions = [DoNotIncludeTests::class]
)
@RunWith(ArchUnitRunner::class)
internal class SystemLayerTest {
    @ArchTest
    val `system layer should only contain classes with permitted name` =
        SystemLayerFixtures.systemLayerClasses
            .should()
            .haveSimpleNameEndingWithOrWrapper("Activity")
            .orShould()
            .haveSimpleNameEndingWith(ArchUnitFixtures.extensionsNameSuffix)
            .orShouldHaveComposableName()
}
