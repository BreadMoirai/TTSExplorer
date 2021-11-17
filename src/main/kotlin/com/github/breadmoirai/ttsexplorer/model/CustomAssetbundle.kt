package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class CustomAssetbundle(
    @Json(name = "AssetbundleURL") val assetbundleURL: String,
    @Json(name = "AssetbundleSecondaryURL") val assetbundleSecondaryURL: String,
    @Json(name = "MaterialIndex") val materialIndex: String,
    @Json(name = "TypeIndex") val typeIndex: String,
    @Json(name = "LoopingEffectIndex") val loopingEffectIndex: String
)