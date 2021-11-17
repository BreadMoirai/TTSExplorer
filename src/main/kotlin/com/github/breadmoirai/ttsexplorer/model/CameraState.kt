package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class CameraState(
    @Json(name = "Position") val position: Vector3,
    @Json(name = "Rotation") val rotation: Vector3,
    @Json(name = "Distance") val distance: Double,
    @Json(name = "Zoomed") val zoomed: Boolean,
    @Json(name = "AbsolutePosition") val absolutePosition: Vector3
)