@file:Suppress("LocalVariableName")

plugins {
    kotlin("jvm")
    application
    id("org.openjfx.javafxplugin") version "0.0.10"
}

group = "com.github.breadmoirai"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.github.breadmoirai.ttsexplorer.MainKt")
}

dependencies {
    // dependencies defined in gradle.properties
    val tornadofx_version: String by rootProject
    val materialfx_version: String by rootProject
    val ikonli_version: String by rootProject
    val moshi_version: String by rootProject

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("no.tornado:tornadofx:$tornadofx_version")
    implementation("io.github.palexdev:materialfx:$materialfx_version")
    implementation("org.kordamp.ikonli:ikonli-javafx:$ikonli_version")
    implementation("org.kordamp.ikonli:ikonli-material2-pack:$ikonli_version")
    implementation("com.squareup.moshi:moshi:$moshi_version")
    implementation("com.squareup.moshi:moshi-kotlin:$moshi_version")
    implementation("com.squareup.moshi:moshi-adapters:$moshi_version")

    // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
    implementation("org.apache.commons:commons-lang3:3.0")

    testImplementation(kotlin("test-junit"))

}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "16"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "16"
    }
}

javafx {
    version = "17"
    modules = listOf("javafx.controls")
}