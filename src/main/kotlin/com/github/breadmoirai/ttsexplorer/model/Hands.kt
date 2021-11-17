package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class Hands(
    @Json(name = "Enable") val enable: Boolean,
    @Json(name = "DisableUnused") val disableUnused: Boolean,
    @Json(name = "Hiding") val hiding: Int
)