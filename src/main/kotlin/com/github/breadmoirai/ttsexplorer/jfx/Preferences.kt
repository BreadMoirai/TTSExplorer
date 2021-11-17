package com.github.breadmoirai.ttsexplorer.jfx

import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import tornadofx.*
import java.util.prefs.Preferences

const val SAVE_PATH_KEY = "tts_save_path"

fun Component.savePath(): StringProperty {
    val p = Preferences.userNodeForPackage(FX.getApplication(scope)!!.javaClass)
    val str = SimpleStringProperty(p.get(SAVE_PATH_KEY, null))
    str.onChange {
        p.put(SAVE_PATH_KEY, it)
    }
    return str
}