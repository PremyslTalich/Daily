package cz.talich.daily.app.architecture

import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.core.importer.Location
import java.util.regex.Pattern

class DoNotIncludeTests : ImportOption {
    override fun includes(location: Location) = EXCLUDED.none(location::matches)

    private companion object {
        private val ANDROID_TESTS = Pattern.compile(".+UnitTest.+\\.class")
        private val JAVA_TESTS = Pattern.compile(".*/build/classes/([^/]+/)?test/.*")
        private val JAVA_TEST_TESTS = Pattern.compile(".*-test/build/.*([^/]+/)?test/.*")

        private val EXCLUDED = setOf(ANDROID_TESTS, JAVA_TESTS, JAVA_TEST_TESTS)
    }
}
