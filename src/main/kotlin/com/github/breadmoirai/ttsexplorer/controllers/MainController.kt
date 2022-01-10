package com.github.breadmoirai.ttsexplorer.controllers

import com.github.breadmoirai.ttsexplorer.services.TTSDirectory
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*

class MainController : Controller() {
    val ttsDirectory: ObjectProperty<TTSDirectory> = SimpleObjectProperty(null)
}