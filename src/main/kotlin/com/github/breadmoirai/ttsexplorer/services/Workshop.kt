package com.github.breadmoirai.ttsexplorer.services

import java.io.File

class Workshop private constructor(private val workshopDir: File, private val _error: Errorable) :
    IErrorable by _error {

    constructor(workshopDir: File) : this(workshopDir, Errorable())

    val modList: ModList by lazy { ModList(workshopDir.resolve("WorkshopFileInfos.json")) }

    init {
        run {
            if (!workshopDir.exists()) {
                return@run _error("Workshop Directory does not exist")
            }
            if (!workshopDir.isDirectory) {
                return@run _error("Workshop Directory is not a directory")
            }
            if (!workshopDir.canRead()) {
                return@run _error("This application does not have permissions to read the Workshop directory!")
            }
            if (modList.hasError) {
                return@run _error(modList.error)
            }
        }
    }
}
