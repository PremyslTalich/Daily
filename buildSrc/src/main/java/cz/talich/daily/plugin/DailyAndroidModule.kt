package cz.talich.daily.plugin

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile

class DailyAndroidModule : Plugin<Project> {
    override fun apply(project: Project) {
        project.configurePlugins()
        project.configureDependencies()
        project.configureAndroid()
    }
}

private fun Project.configurePlugins() {
    plugins.apply("com.android.library")
    plugins.apply("org.jetbrains.kotlin.android")
    plugins.apply("com.android.library")
}

private fun Project.configureDependencies() {
    dependencies.apply {

    }
}

private fun Project.configureAndroid() {
    extensions.getByType<LibraryExtension>().run {
        buildToolsVersion = AndroidSdk.buildToolsVersion
        compileSdk = AndroidSdk.compileSdkVersion

        defaultConfig {
            minSdk = AndroidSdk.minSdkVersion
            targetSdk = AndroidSdk.targetSdkVersion
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        buildFeatures.apply {
            viewBinding = true
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = AndroidSdk.composeCompiler
        }

        tasks.withType(KotlinCompile::class.java) {
            kotlinOptions {
                freeCompilerArgs = listOf(
                    "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-Xuse-experimental=kotlinx.coroutines.InternalCoroutinesApi"
                )
            }
        }

        tasks.withType(KotlinJvmCompile::class.java) {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }

        buildTypes {
            getByName("debug") {
                sourceSets {
                    getByName("debug").java.srcDirs("src/main/java", "src/debug/java")
                }

                isTestCoverageEnabled = false
                isMinifyEnabled = false
            }

            getByName("release") {
                sourceSets {
                    getByName("release").java.srcDirs("src/main/java", "src/release/java")
                }

                isTestCoverageEnabled = false
                isMinifyEnabled = false

                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            }
        }
    }
}
