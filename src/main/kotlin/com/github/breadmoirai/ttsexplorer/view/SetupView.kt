package com.github.breadmoirai.ttsexplorer.view

import com.github.breadmoirai.ttsexplorer.controllers.MainController
import com.github.breadmoirai.ttsexplorer.services.TTSDirectory
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.stage.DirectoryChooser
import jfxtras.styles.jmetro.MDL2IconFont
import tornadofx.*
import java.io.File

class SetupView : View("Initialize") {
    private val main: MainController by inject()
    private val ttsDir = main.ttsDirectory
    private val saveDirEntry = SimpleStringProperty(this, "saveDirPath", config.string("save_dir_path"))

    override val root = vbox(15, Pos.CENTER) {
        val label = label("Tabletop Simulator Save Directory")
        val feedback = SimpleStringProperty()
        if (saveDirEntry.value.isNullOrBlank()) {
            saveDirEntry.value = TTSDirectory.defaultDir()?.absolutePath ?: ""
        }
        hbox(10, Pos.CENTER) {
            textfield {
                text = saveDirEntry.value
                saveDirEntry.bindBidirectional(textProperty())
                style {
                    prefWidth = 500.px
                }
            }
            button(graphic = MDL2IconFont("\uED25")) {
                onLeftClick {
                    val file = DirectoryChooser().run {
                        title = "Choose Tabletop Simulator Save Directory"
                        initialDirectory = TTSDirectory.defaultDir()
                        showDialog(scene.window)
                    }
                    if (file != null) {
                        saveDirEntry.set(file.absolutePath)
                    }
                }
            }
        }
        ttsDir.bind(saveDirEntry.objectBinding { if (it != null) TTSDirectory(File(it)) else null })
        label {
            style {
                textFill = Color.TOMATO
            }
            isWrapText = true
            textProperty().bind(ttsDir.stringBinding {
                if (it != null && it.hasError) it.error else ""
            })
        }
        button("Continue") {
            enableWhen(ttsDir.booleanBinding { it != null && !it.hasError })
            action {
                config.set("save_dir_path" to saveDirEntry.value)
                config.save()
                replaceWith<BrowserView>(ViewTransition.FadeThrough(1.seconds))
            }
        }
    }

}