package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class ComponentTags(
    @Json(name = "labels") val labels: List<Label>
)