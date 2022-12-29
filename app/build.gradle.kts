plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("daily-android-detekt-plugin")
    id("com.vanniktech.dependency.graph.generator")
}

android {
    buildToolsVersion = AndroidSdk.buildToolsVersion
    compileSdk = AndroidSdk.compileSdkVersion
    namespace = Application.namespace

    defaultConfig {
        applicationId = Application.id
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion
        versionCode = Application.Version.code
        versionName = Application.Version.name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidSdk.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += listOf("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    addModule(Feature.main)

    add(Testing.dependencies)
    add(AndroidX.dependencies)
    add(MaterialDesign.dependencies)

    implementation(Accompanist.systemUiController)
}

tasks {
    register("generateAndCopyDependencyGraphs", Copy::class) {
        dependsOn("generateProjectDependencyGraph", "generateDependencyGraph")

        from(
            "build/reports/project-dependency-graph/project-dependency-graph.png",
            "build/reports/dependency-graph/dependency-graph.png"
        )
        into("${rootProject.projectDir}/dependency graphs")
    }
}
