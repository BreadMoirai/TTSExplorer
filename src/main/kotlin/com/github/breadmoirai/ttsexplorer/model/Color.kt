package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class Color(
    @Json(name = "r") val r: Double,
    @Json(name = "g") val g: Double,
    @Json(name = "b") val b: Double,
    @Json(name = "a") val a: Double = 1.0
)