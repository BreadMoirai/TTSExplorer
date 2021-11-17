package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class Text(
    @Json(name = "Text") var text : String,
    @Json(name = "colorstate") var color : Color,
    @Json(name = "fontSize") var fontSize : Int
)