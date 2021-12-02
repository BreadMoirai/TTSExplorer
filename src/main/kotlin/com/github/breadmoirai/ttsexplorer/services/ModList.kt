package com.github.breadmoirai.ttsexplorer.services

import com.github.breadmoirai.ttsexplorer.model.WorkshopFileInfo
import com.github.breadmoirai.ttsexplorer.services.JsonParser.parse
import java.io.File

class ModList private constructor(private val modListFile: File, private val _error: Errorable) :
    IErrorable by _error {
    constructor(modListFile: File): this(modListFile, Errorable())

    private lateinit var _infoList: Set<WorkshopFileInfo>
    val infoList: Set<WorkshopFileInfo>
        get() = _infoList

    init {
        run {
            if(!modListFile.exists()) {
                return@run _error("WorkshopFileInfos.json does not exist at ${modListFile.absolutePath}. " +
                        "Please launch TabletopSimulator to generate this file.")
            }
            if (!modListFile.canRead()) {
                return@run _error("This application does not have permission " +
                        "to read WorkshopFileInfos.json at ${modListFile.absolutePath}. " +
                        "Try launching this application in administrator mode.")
            }
            val list = modListFile.parse<List<WorkshopFileInfo>>()
            if (list == null) {
                return@run _error("Could not successfully parse WorkshopFileInfos.json.")
            }
            _infoList = list.toSet()
        }
    }
}