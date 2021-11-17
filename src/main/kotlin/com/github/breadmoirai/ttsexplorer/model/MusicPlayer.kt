package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class MusicPlayer(
    @Json(name = "RepeatSong") val repeatSong : Boolean,
    @Json(name = "PlaylistEntry") val playlistEntry : Int,
    @Json(name = "CurrentAudioTitle") val currentAudioTitle : String,
    @Json(name = "CurrentAudioURL") val currentAudioURL : String,
    @Json(name = "AudioLibrary") val audioLibrary : List<String>
)