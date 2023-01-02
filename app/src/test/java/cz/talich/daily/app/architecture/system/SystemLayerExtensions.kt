package cz.talich.daily.app.architecture.system

import com.tngtech.archunit.lang.syntax.elements.ClassesShouldConjunction
import cz.talich.daily.app.architecture.haveSimpleNameEndingWithOrWrapper

private val composableNames = listOf(
    "Screen",
    "Theme",
    "Shape",
    "Type",
)

internal fun ClassesShouldConjunction.orShouldHaveComposableName(): ClassesShouldConjunction {
    var result = this

    composableNames.forEach { name ->
        result = result.orShould().haveSimpleNameEndingWithOrWrapper(name)
    }

    return result
}
