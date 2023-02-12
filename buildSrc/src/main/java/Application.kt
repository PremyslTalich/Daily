object Application {
    const val id = "cz.talich.daily"
    const val namespace = id

    object Version {
        const val name = "1.2"
        val code: Int
            get() = name.replace(".", "").toInt()
    }
}
