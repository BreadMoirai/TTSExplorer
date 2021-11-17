package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class CustomShader(
    @Json(name = "SpecularColor") var SpecularColor: Color,
    @Json(name = "SpecularIntensity") var SpecularIntensity: Double,
    @Json(name = "SpecularSharpness") var SpecularSharpness: Double,
    @Json(name = "FresnelStrength") var FresnelStrength: Double
)