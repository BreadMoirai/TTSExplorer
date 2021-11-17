package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class Grid(
    @Json(name = "Type") val type: Int,
    @Json(name = "Lines") val lines: Boolean,
    @Json(name = "Color") val color: Color,
    @Json(name = "Opacity") val opacity: Double,
    @Json(name = "ThickLines") val thickLines: Boolean,
    @Json(name = "Snapping") val snapping: Boolean,
    @Json(name = "Offset") val offset: Boolean,
    @Json(name = "BothSnapping") val bothSnapping: Boolean,
    @Json(name = "xSize") val xSize: Double,
    @Json(name = "ySize") val ySize: Double,
    @Json(name = "PosOffset") val posOffset: Vector3
)