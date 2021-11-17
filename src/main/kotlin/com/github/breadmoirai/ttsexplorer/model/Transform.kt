package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class Transform(
    @Json(name = "posX") val posX: Double,
    @Json(name = "posY") val posY: Double,
    @Json(name = "posZ") val posZ: Double,
    @Json(name = "rotX") val rotX: Double,
    @Json(name = "rotY") val rotY: Double,
    @Json(name = "rotZ") val rotZ: Double,
    @Json(name = "scaleX") val scaleX: Double,
    @Json(name = "scaleY") val scaleY: Double,
    @Json(name = "scaleZ") val scaleZ: Double
)