package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class CustomToken(
    @Json(name = "Thickness") var thickness: Double,
    @Json(name = "MergeDistancePixels") var mergeDistancePixels: Double,
    @Json(name = "StandUp") var standUp: Boolean,
    @Json(name = "Stackable") var stackable: Boolean
)
