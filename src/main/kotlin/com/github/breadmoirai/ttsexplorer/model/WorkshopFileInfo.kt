package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class WorkshopFileInfo(
    @Json(name = "Directory") val filePath: String,
    @Json(name = "Name") val name: String,
    @Json(name = "UpdateTime") val updateTime: Long
)