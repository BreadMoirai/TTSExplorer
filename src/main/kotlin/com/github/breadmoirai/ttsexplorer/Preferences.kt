package com.github.breadmoirai.ttsexplorer

import com.github.breadmoirai.ttsexplorer.services.TTSDirectory
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import tornadofx.*
import java.util.prefs.Preferences

const val SAVE_PATH_KEY = "tts_save_path"

object Preferences {
    fun saveDirPath(): StringProperty {
        val p = Preferences.userNodeForPackage(this.javaClass)
        val str = SimpleStringProperty(p.get(SAVE_PATH_KEY, TTSDirectory.defaultDir()?.path))
        str.onChange {
            p.put(SAVE_PATH_KEY, it)
        }
        return str
    }
}