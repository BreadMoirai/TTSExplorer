package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class ObjectState (
	@Json(name = "GUID") val guid : String,
	@Json(name = "Name") val name : String,
	@Json(name = "Transform") val transform : Transform,
	@Json(name = "Nickname") val nickname : String,
	@Json(name = "Description") val description : String,
	@Json(name = "GMNotes") val gmNotes : String,
	@Json(name = "ColorDiffuse") val colorDiffuse : Color,
	@Json(name = "Tags") val tags : List<String>?,
	@Json(name = "LayoutGroupSortIndex") val layoutGroupSortIndex : Int,
	@Json(name = "Value") val value : Int?,
	@Json(name = "Locked") val locked : Boolean,
	@Json(name = "Grid") val grid : Boolean,
	@Json(name = "Snap") val snap : Boolean,
	@Json(name = "IgnoreFoW") val ignoreFoW : Boolean,
	@Json(name = "MeasureMovement") val measureMovement : Boolean,
	@Json(name = "DragSelectable") val dragSelectable : Boolean,
	@Json(name = "Autoraise") val autoraise : Boolean,
	@Json(name = "Sticky") val sticky : Boolean,
	@Json(name = "Tooltip") val tooltip : Boolean,
	@Json(name = "GridProjection") val gridProjection : Boolean,
	@Json(name = "HideWhenFaceDown") val hideWhenFaceDown : Boolean?,
	@Json(name = "Hands") val hands : Boolean,
	@Json(name = "CustomPDF") val customPDF : CustomPDF?,
	@Json(name = "Tablet") val tablet : Tablet?,
	@Json(name = "CardID") val cardID : Int?,
	@Json(name = "SidewaysCard") val sidewaysCard : Boolean?,
	@Json(name = "CustomDeck") val customDeck : Map<String, CustomDeck>?,
	@Json(name = "DeckIDs") val deckIDs : List<Int>?,
	@Json(name = "MaterialIndex") val materialIndex : Int?,
	@Json(name = "CustomAssetbundle") val customAssetbundle: CustomAssetbundle?,
	@Json(name = "CustomImage") val customImage: CustomImage?,
	@Json(name = "MeshIndex") val meshIndex: Int?,
	@Json(name = "Number") val number: Int?,
	@Json(name = "CustomMesh") val customMesh: CustomMesh?,
	@Json(name = "FogColor") val fogColor : String?,
	@Json(name = "Bag") val bag : Bag?,
	@Json(name = "Text") val text : Text?,
	@Json(name = "LuaScript") val luaScript : String,
	@Json(name = "LuaScriptState") val luaScriptState : String,
	@Json(name = "XmlUI") val xmlUI : String,
	@Json(name = "CustomUIAssets") val customUIAssets : List<CustomUIAsset>?,
	@Json(name = "AttachedSnapPoints") val attachedSnapPoints : List<SnapPoint>?,
	@Json(name = "RotationValues") val rotationValues : List<RotationValue>?,
	@Json(name = "ContainedObjects") val containedObjects: List<ObjectState>?,
	@Json(name = "ChildObjects") val childObjects: List<ObjectState>?,
	@Json(name = "States") val states: Map<String, ObjectState>?,
)