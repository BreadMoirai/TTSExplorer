package com.github.breadmoirai.ttsexplorer.services

import org.apache.commons.lang3.SystemUtils
import java.io.File

class TTSDirectory private constructor(
    private val rootDir: File,
    private val _error: Errorable
) : IErrorable by _error {

    constructor(rootDir: File) : this(rootDir, Errorable())

    companion object {
        fun defaultDir(): File? {
            return when {
                SystemUtils.IS_OS_WINDOWS -> SystemUtils.getUserHome()
                    .resolve("Documents\\My Games\\Tabletop Simulator")
                SystemUtils.IS_OS_MAC -> SystemUtils.getUserHome()
                    .resolve("Library/Tabletop Simulator")
                SystemUtils.IS_OS_LINUX -> SystemUtils.getUserHome()
                    .resolve(".local/share/Tabletop Simulator")
                else -> null
            }
        }
    }

    private val modsDir = rootDir.resolve("Mods")
    private val saveDir = rootDir.resolve("Saves")

    val mods = ModsDirectory(modsDir)

    init {
        run {
            if (!rootDir.exists()) {
                return@run _error("File path provided does not exist!")
            }
            if (!rootDir.isDirectory) {
                return@run _error("File path provided is not a directory!")
            }
            if (!rootDir.canRead()) {
                return@run _error("This application does not have permissions to read this directory!")
            }
            val list = rootDir.list()
            if (list == null || list.isEmpty()) {
                return@run _error("The directory provided is empty!")
            }
            if (!modsDir.exists() && !saveDir.exists()) {
                return@run _error("Could not find Saves directory or Mods directory")
            }
            if (mods.hasError) {
                return@run _error(mods.error)
            }
        }
    }
}

