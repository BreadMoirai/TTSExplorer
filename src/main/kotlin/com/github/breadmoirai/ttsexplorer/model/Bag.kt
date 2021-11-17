package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class Bag(
    @Json(name = "Order") val order: Int
)
