package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class Vector3(
    @Json(name = "x") val x: Double,
    @Json(name = "y") val y: Double,
    @Json(name = "z") val z: Double
)