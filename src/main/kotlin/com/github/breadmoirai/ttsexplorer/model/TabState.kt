package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class TabState(
    @Json(name = "title") val title: String,
    @Json(name = "body") val body: String,
    @Json(name = "color") val color: String,
    @Json(name = "visibleColor") val visibleColor: Color,
    @Json(name = "id") val id: Int,
)