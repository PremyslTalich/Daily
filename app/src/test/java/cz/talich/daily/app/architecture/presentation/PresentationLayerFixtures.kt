package cz.talich.daily.app.architecture.presentation

import androidx.lifecycle.ViewModel
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.elements.GivenClassesConjunction
import cz.talich.daily.app.architecture.ArchUnitFixtures
import cz.talich.daily.library.mvvm.presentation.AbstractViewModel

internal object PresentationLayerFixtures {
    val androidViewModel = ViewModel::class.java
    val dailyViewModel = AbstractViewModel::class.java
    const val viewModelNameSuffix = "ViewModel"

    val presentationLayerClasses: GivenClassesConjunction = classes().that()
        .resideInAPackage(ArchUnitFixtures.presentationLayerPackage)
        .and()
        .areTopLevelClasses()
}