buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
        classpath("com.github.hyperdevs-team:poeditor-android-gradle-plugin:3.1.1")
        classpath("com.vanniktech:gradle-dependency-graph-generator-plugin:0.8.0")
    }
}
