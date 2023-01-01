@file:Suppress("PropertyName", "VariableNaming", "HasPlatformType")

package cz.talich.daily.app.architecture.presentation

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchUnitRunner
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import cz.talich.daily.app.architecture.ArchUnitFixtures
import cz.talich.daily.app.architecture.presentation.PresentationLayerFixtures.androidViewModel
import cz.talich.daily.app.architecture.presentation.PresentationLayerFixtures.dailyViewModel
import cz.talich.daily.app.architecture.presentation.PresentationLayerFixtures.viewModelNameSuffix
import org.junit.runner.RunWith


@AnalyzeClasses(packages = [ArchUnitFixtures.packages])
@RunWith(ArchUnitRunner::class)
internal class ViewModelTest {
    @ArchTest
    val `all classes named ViewModel should subclass AbstractViewModel` =
        ArchRuleDefinition.classes().that().haveSimpleNameEndingWith(viewModelNameSuffix)
            .should().beAssignableTo(androidViewModel)

    @ArchTest
    val `view model subclasses should have correct name` =
        ArchRuleDefinition.classes().that().areAssignableTo(androidViewModel)
            .should().haveSimpleNameEndingWith(viewModelNameSuffix)

    @ArchTest
    val `view model subclasses should extend AbstractViewModel` =
        ArchRuleDefinition.classes().that().areAssignableTo(androidViewModel)
            .should().beAssignableTo(dailyViewModel)
}
