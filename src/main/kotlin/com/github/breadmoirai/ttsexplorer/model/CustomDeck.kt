package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

class CustomDeck(
    @Json(name = "FaceURL") var faceURL: String,
    @Json(name = "BackURL") var backURL: String,
    @Json(name = "NumWidth") var numWidth: Int,
    @Json(name = "NumHeight") var numHeight: Int,
    @Json(name = "BackIsHidden") var backIsHidden: Boolean,
    @Json(name = "UniqueBack") var uniqueBack: Boolean,
    @Json(name = "Type") var type: Int
)