package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class Label (
	@Json(name = "displayed") val displayed : String,
	@Json(name = "normalized") val normalized : String
)