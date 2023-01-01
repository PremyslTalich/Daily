package cz.talich.daily.app.architecture

import com.tngtech.archunit.lang.syntax.elements.ClassesShould

internal fun ClassesShould.haveSimpleNameEndingWithOrWrapper(name: String) =
    haveSimpleNameEndingWith(name).orShould().haveSimpleNameEndingWith("${name}Kt")
