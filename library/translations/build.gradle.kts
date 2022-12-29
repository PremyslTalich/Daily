plugins {
    id("daily-android-module")
    id("com.hyperdevs.poeditor")
}

android {
    namespace = moduleNamespace

    localProperties?.let {
        poEditor {
            setApiToken(it.getProperty("poEditorApiToken"))
            setProjectId(it.getProperty("poEditorProjectId").toInt())
            setDefaultLang("en")
        }
    }
}
