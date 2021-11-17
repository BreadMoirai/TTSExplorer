package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class VectorLines(
    @Json(name = "points3") val points3: List<Vector3>,
    @Json(name = "color") val color: Color,
    @Json(name = "thickness") val thickness: Double,
    @Json(name = "loop") val loop: Boolean?
)