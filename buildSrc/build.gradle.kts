plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.5.0"
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.4.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.21.0")
}

gradlePlugin {
    plugins {
        register("daily-android-module") {
            id = "daily-android-module"
            implementationClass = "cz.talich.daily.plugin.DailyAndroidModule"
        }

        register("daily-android-detekt-plugin") {
            id = "daily-android-detekt-plugin"
            implementationClass = "cz.talich.daily.plugin.DailyAndroidDetektPlugin"
        }

        register("daily-dependency-graph-plugin") {
            id = "daily-dependency-graph-plugin"
            implementationClass = "cz.talich.daily.plugin.DailyDependencyGraphPlugin"
        }
    }
}
