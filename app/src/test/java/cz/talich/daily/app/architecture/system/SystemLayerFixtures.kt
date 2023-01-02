package cz.talich.daily.app.architecture.system

import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.lang.syntax.elements.GivenClassesConjunction
import cz.talich.daily.app.architecture.ArchUnitFixtures

internal object SystemLayerFixtures {
    val systemLayerClasses: GivenClassesConjunction = ArchRuleDefinition.classes().that()
        .resideInAPackage("..${ArchUnitFixtures.Layers.system}")
        .and()
        .areTopLevelClasses()
}
