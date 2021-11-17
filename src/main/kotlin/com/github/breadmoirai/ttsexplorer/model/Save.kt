package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class Save (
	@Json(name = "SaveName") val saveName : String,
	@Json(name = "EpochTime") val epochTime : Int?,
	@Json(name = "Date") val date : String,
	@Json(name = "VersionNumber") val versionNumber : String,
	@Json(name = "GameMode") val gameMode : String,
	@Json(name = "GameType") val gameType : String,
	@Json(name = "GameComplexity") val gameComplexity : String,
	@Json(name = "PlayingTime") val playingTime : List<Int>?,
	@Json(name = "PlayerCounts") val playerCounts : List<Int>?,
	@Json(name = "Tags") val tags : List<String>,
	@Json(name = "Gravity") val gravity : Double,
	@Json(name = "PlayArea") val playArea : Double,
	@Json(name = "Table") val table : String,
	@Json(name = "Sky") val sky : String,
	@Json(name = "SkyURL") val skyURL : String?,
	@Json(name = "Note") val note : String,
	@Json(name = "Rules") val rules : String?,
	@Json(name = "MusicPlayer") val musicPlayer : MusicPlayer?,
	@Json(name = "TabStates") val tabStates : Map<String, TabState>,
	@Json(name = "Grid") val grid : Grid,
	@Json(name = "Lighting") val lighting : Lighting,
	@Json(name = "Hands") val hands : Hands,
	@Json(name = "ComponentTags") val componentTags : ComponentTags,
	@Json(name = "Turns") val turns : Turns,
	@Json(name = "CameraStates") val cameraStates : List<CameraState>?,
	@Json(name = "DecalPallet") val decalPallet : List<String>,
	@Json(name = "LuaScript") val luaScript : String,
	@Json(name = "LuaScriptState") val luaScriptState : String,
	@Json(name = "XmlUI") val xmlUI : String,
	@Json(name = "CustomUIAssets") val customUIAssets : List<CustomUIAsset>?,
	@Json(name = "VectorLines") val vectorLines : List<VectorLines>?,
	@Json(name = "SnapPoints") val snapPoints : List<SnapPoint>,
	@Json(name = "ObjectStates") val objectStates : List<ObjectState>
)