package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class SnapPoint(
    @Json(name = "Position") val position: Vector3,
    @Json(name = "Rotation") val rotation: Vector3?,
    @Json(name = "Tags") val tags: List<String>?
)