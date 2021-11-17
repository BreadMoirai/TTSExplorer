package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class CustomImage(
    @Json(name = "ImageURL") var imageURL: String,
    @Json(name = "ImageSecondaryURL") var imageSecondaryURL: String,
    @Json(name = "ImageScalar") var imageScalar: Double,
    @Json(name = "WidthScale") var widthScale: Double,
    @Json(name = "CustomTile") var customTile: CustomTile?,
    @Json(name = "CustomToken") var customToken: CustomToken?,
    @Json(name = "CustomDice") var customDice: CustomDice?
)
