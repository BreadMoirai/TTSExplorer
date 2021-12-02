package com.github.breadmoirai.ttsexplorer.jfx

import com.github.breadmoirai.ttsexplorer.services.TTSDirectory
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import tornadofx.*
import java.util.prefs.Preferences

const val SAVE_PATH_KEY = "tts_save_path"

object Preferences {
    fun saveDirPath(component: Component): StringProperty {
        val p = Preferences.userNodeForPackage(FX.getApplication(component.scope)!!.javaClass)
        val str = SimpleStringProperty(p.get(SAVE_PATH_KEY, TTSDirectory.defaultDir()?.path))
        str.onChange {
            p.put(SAVE_PATH_KEY, it)
        }
        return str
    }
}