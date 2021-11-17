package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class Turns(
    @Json(name = "Enable") val enable: Boolean,
    @Json(name = "Type") val type: Int,
    @Json(name = "TurnOrder") val turnOrder: List<String>,
    @Json(name = "Reverse") val reverse: Boolean,
    @Json(name = "SkipEmpty") val skipEmpty: Boolean,
    @Json(name = "DisableInteractions") val disableInteractions: Boolean,
    @Json(name = "PassTurns") val passTurns: Boolean,
    @Json(name = "TurnColor") val turnColor: String
)