package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class Lighting(
    @Json(name = "LightIntensity") val lightIntensity: Double,
    @Json(name = "LightColor") val lightColor: Color,
    @Json(name = "AmbientIntensity") val ambientIntensity: Double,
    @Json(name = "AmbientType") val ambientType: Int,
    @Json(name = "AmbientSkyColor") val ambientSkyColor: Color,
    @Json(name = "AmbientEquatorColor") val ambientEquatorColor: Color,
    @Json(name = "AmbientGroundColor") val ambientGroundColor: Color,
    @Json(name = "ReflectionIntensity") val reflectionIntensity: Int,
    @Json(name = "LutIndex") val lutIndex: Int,
    @Json(name = "LutContribution") val lutContribution: Int
)