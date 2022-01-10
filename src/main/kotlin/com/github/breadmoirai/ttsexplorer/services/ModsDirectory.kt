package com.github.breadmoirai.ttsexplorer.services

import java.io.File

class ModsDirectory private constructor(
    private val modDir: File,
    private val _error: Errorable
    ) : IErrorable by _error {

    constructor(modDir: File): this(modDir, Errorable())

    val workshop: Workshop = Workshop(modDir.resolve("Workshop"))

    init {
        run {
            if (!modDir.exists()) {
                return@run _error("Mods Directory does not exist")
            }
            if (!modDir.isDirectory) {
                return@run _error("Mods Directory is not a directory")
            }
            if (!modDir.canRead()) {
                return@run _error("This application does not have permissions to read the Mods directory!")
            }
            if (workshop.hasError) {
                return@run _error(workshop.error)
            }
        }
    }
}