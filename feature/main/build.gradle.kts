plugins {
    id("daily-android-module")
}

android {
    namespace = moduleNamespace
}

dependencies {
    addModule(Library.design)
    addModule(Library.mvvm)
    addModule(Library.translations)

    add(Testing.dependencies)
    add(AndroidX.dependencies)
    add(MaterialDesign.dependencies)

    implementation(Accompanist.systemUiController)
}
