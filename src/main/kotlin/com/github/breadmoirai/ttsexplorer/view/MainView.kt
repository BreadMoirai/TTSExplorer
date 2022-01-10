package com.github.breadmoirai.ttsexplorer.view

import com.github.breadmoirai.ttsexplorer.controllers.MainController
import javafx.scene.layout.Priority
import jfxtras.styles.jmetro.JMetro
import jfxtras.styles.jmetro.JMetroStyleClass
import jfxtras.styles.jmetro.Style
import tornadofx.*

class MainView : View("TTS Explorer") {
    private val main: MainController by inject()

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
                paddingAll = 50
            }
            add<SetupView>()
        }
    }

    override fun onBeforeShow() {
        JMetro(Style.DARK).scene = primaryStage.scene
    }
}
