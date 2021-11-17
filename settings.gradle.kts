@file:Suppress("LocalVariableName")

rootProject.name = "tts-explorer"

pluginManagement {
    val kotlin_version: String by settings
    plugins {
        kotlin("jvm") version kotlin_version
    }
}
