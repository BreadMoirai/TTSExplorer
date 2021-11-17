package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class CustomTile(
    @Json(name = "Type") var type: Int,
    @Json(name = "Thickness") var thickness: Double,
    @Json(name = "Stackable") var stackable: Boolean,
    @Json(name = "Stretch") var stretch: Boolean
)