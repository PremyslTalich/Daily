plugins {
    id("daily-android-module")
}

android {
    namespace = moduleNamespace
}

dependencies {
    add(Testing.dependencies)
    implementation(AndroidX.composeViewModel)
}
