import java.util.*

plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.5.0"
}

repositories {
    jcenter()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
}

gradlePlugin {
    plugins {
        register("daily-android-module") {
            id = "daily-android-module"
            implementationClass = "cz.talich.daily.plugin.DailyAndroidModule"
        }
    }
}
