plugins {
    id("daily-android-module")
    id("com.hyperdevs.poeditor")
}

android {
    namespace = moduleNamespace

    poEditor {
        with (localProperties) {
            setApiToken(getProperty("poEditorApiToken"))
            setProjectId(getProperty("poEditorProjectId").toInt())
            setDefaultLang("en")
        }
    }
}
