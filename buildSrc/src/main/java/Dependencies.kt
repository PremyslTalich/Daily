object Testing {
    private const val jUnit = "junit:junit:4.13.2"
    private const val jUnitExt = "androidx.test.ext:junit:1.1.3"
    private const val jUnitCompose = "androidx.compose.ui:ui-test-junit4:1.1.1"
    private const val kotest = "io.kotest:kotest-assertions-core-jvm:5.5.4"
    private const val mockk = "io.mockk:mockk:1.10.2"
    private const val turbine = "app.cash.turbine:turbine:0.12.1"
    private const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test"

    val dependencies = listOf(
        Pair("testImplementation", jUnit),
        Pair("androidTestImplementation", jUnitExt),
        Pair("androidTestImplementation", jUnitCompose),
        Pair("testImplementation", kotest),
        Pair("testImplementation", mockk),
        Pair("testImplementation", turbine),
        Pair("testImplementation", coroutinesTest)
    )
}

object AndroidX {
    const val core = "androidx.core:core-ktx:1.7.0"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    const val material = "androidx.compose.material:material:1.1.1"
    const val activityCompose = "androidx.activity:activity-compose:1.3.1"
    const val compose = "androidx.compose.ui:ui:1.1.1"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:1.1.1"
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:1.1.1"

    val dependencies = listOf(
        Pair("implementation", core),
        Pair("implementation", lifecycle),
        Pair("implementation", material),
        Pair("implementation", activityCompose),
        Pair("implementation", compose),
        Pair("implementation", composePreview),
        Pair("implementation", composeViewModel),
        Pair("debugImplementation", composeUiTooling)
    )
}

object MaterialDesign {
    private const val material = "com.google.android.material:material:1.3.0-alpha03"

    val dependencies = listOf(
        Pair("implementation", material)
    )
}

object Accompanist {
    const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:0.23.1"
}
