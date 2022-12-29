plugins {
    id("daily-android-module")
}

android {
    namespace = moduleNamespace
}

dependencies {
    add(MaterialDesign.dependencies)
    implementation(AndroidX.material)
}
