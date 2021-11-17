package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class RotationValue(
    @Json(name = "Value") val value: String,
    @Json(name = "Rotation") val rotation: Vector3
)
