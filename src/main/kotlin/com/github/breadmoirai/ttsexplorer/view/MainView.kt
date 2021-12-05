package com.github.breadmoirai.ttsexplorer.view

import com.github.breadmoirai.ttsexplorer.Preferences
import javafx.application.Platform
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.layout.Priority
import javafx.stage.FileChooser
import jfxtras.styles.jmetro.JMetro
import jfxtras.styles.jmetro.JMetroStyleClass
import jfxtras.styles.jmetro.MDL2IconFont
import jfxtras.styles.jmetro.Style
import tornadofx.*

class MainView : View("TTS Explorer") {
    override val root = vbox {
        style {
            styleClass += JMetroStyleClass.BACKGROUND
            prefHeight = 550.px
            prefWidth = 960.px
        }
        stackpane {
            style {
                vgrow = Priority.ALWAYS
                hgrow = Priority.ALWAYS
            }
            val saveDirPath = Preferences.saveDirPath()
            vbox(15, Pos.CENTER) {
                val label = label("Tabletop Simulator Save Directory")
                val saveDirEntry = SimpleStringProperty(saveDirPath.value)
                val feedback = SimpleStringProperty()
                hbox(10, Pos.CENTER) {
                    textfield {
                        this.textProperty().bindBidirectional(saveDirEntry)
                        style {
                            prefWidth = 500.px
                        }
                        Platform.runLater {
                            requestFocus()
                        }
                    }
                    button(graphic = MDL2IconFont("\uED25")) {
                        onLeftClick {
                            val file = FileChooser().showOpenDialog(scene.window)
                            if (file != null) {
                                saveDirEntry.value = file.absolutePath
                            }
                        }
                    }
                }
                label {

                }
            }
        }
    }

    override fun onBeforeShow() {
        JMetro(Style.DARK).scene = primaryStage.scene
    }
}
