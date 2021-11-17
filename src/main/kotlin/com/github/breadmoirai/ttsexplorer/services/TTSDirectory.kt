package com.github.breadmoirai.ttsexplorer.services

import org.apache.commons.lang3.SystemUtils
import java.io.File

class TTSDirectory(val rootDir: File) {
    companion object {
        fun defaultDir(): File? {
            return when {
                SystemUtils.IS_OS_WINDOWS -> SystemUtils.getUserHome().resolve("Documents\\My Games\\Tabletop Simulator")
                SystemUtils.IS_OS_MAC -> SystemUtils.getUserHome().resolve("Library/Tabletop Simulator")
                SystemUtils.IS_OS_LINUX -> SystemUtils.getUserHome().resolve(".local/share/Tabletop Simulator")
                else -> null
            }
        }
    }

    private val modsDir = rootDir.resolve("Mods")
    private val saveDir = rootDir.resolve("Saves")

    fun validate(): ValidationResult {
        if (!rootDir.exists()) return ValidationResult.fail("File path provided does not exist!")
        if (!rootDir.isDirectory) return ValidationResult.fail("File path provided is not a directory!")
        if (!rootDir.canRead())
            return ValidationResult.fail("This application does not have permissions to read this directory!")
        val list = rootDir.list()
        if (list == null || list.isEmpty()) return ValidationResult.fail("The directory provided is empty!")
        if (!modsDir.exists() && !saveDir.exists()) {
            return ValidationResult.fail("Could not find Saves directory or Mods directory")
        }
        // TODO
        return ValidationResult.success()
    }
}

data class ValidationResult(val success: Boolean, val message: String) {
    companion object {
        fun success() = ValidationResult(true, "")
        fun fail(message: String) = ValidationResult(false, message)
    }
}