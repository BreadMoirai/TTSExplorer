package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json


data class CustomUIAsset(
    @Json(name = "Name") val name: String,
    @Json(name = "URL") val url: String
)
