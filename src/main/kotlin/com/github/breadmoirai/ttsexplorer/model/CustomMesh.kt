package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class CustomMesh(
    @Json(name = "MeshURL") var meshURL : String,
    @Json(name = "DiffuseURL") var diffuseURL : String,
    @Json(name = "NormalURL") var normalURL : String,
    @Json(name = "ColliderURL") var colliderURL : String,
    @Json(name = "Convex") var convex : Boolean,
    @Json(name = "MaterialIndex") var materialIndex : Int,
    @Json(name = "TypeIndex") var typeIndex : Int,
    @Json(name = "CustomShader") var customShader : CustomShader?,
    @Json(name = "CastShadows") var castShadows : Boolean
    )
