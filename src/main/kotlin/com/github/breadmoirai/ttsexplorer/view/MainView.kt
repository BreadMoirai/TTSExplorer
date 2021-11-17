package com.github.breadmoirai.ttsexplorer.view

import com.github.breadmoirai.ttsexplorer.jfx.savePath
import com.github.breadmoirai.ttsexplorer.jfx.toggleBinding
import com.github.breadmoirai.ttsexplorer.mfx.fontButton
import com.github.breadmoirai.ttsexplorer.mfx.label
import javafx.geometry.Pos
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import javafx.stage.FileChooser
import javafx.stage.StageStyle
import org.kordamp.ikonli.material2.Material2AL
import org.kordamp.ikonli.material2.Material2MZ
import tornadofx.View
import tornadofx.box
import tornadofx.c
import tornadofx.hbox
import tornadofx.hgrow
import tornadofx.onLeftClick
import tornadofx.px
import tornadofx.spacer
import tornadofx.stackpane
import tornadofx.style
import tornadofx.textfield
import tornadofx.vbox
import tornadofx.vgrow

class MainView : View("TTS Explorer") {
    override val root = vbox {
        style {
            backgroundColor += c("#FAFAFA")
            backgroundRadius += box(5.px)
            borderRadius += box(5.px)
            prefHeight = 550.px
            prefWidth = 960.px
        }
        var xOffset = primaryStage.x
        var yOffset = primaryStage.y
        setOnMousePressed { event ->
            xOffset = primaryStage.x - event.screenX
            yOffset = primaryStage.y - event.screenY
        }
        setOnMouseDragged { event ->
            primaryStage.x = event.screenX + xOffset
            primaryStage.y = event.screenY + yOffset
        }
        vbox {
            hbox(0, Pos.TOP_LEFT) {
                spacer()
                hbox(5, Pos.TOP_RIGHT) {
                    style {
                        padding = box(5.px)
                    }
                    fontButton(Material2AL.FULLSCREEN, 20) { icon ->
                        icon.iconCodeProperty().bind(
                            primaryStage.fullScreenProperty()
                                .toggleBinding(Material2AL.FULLSCREEN_EXIT, Material2AL.FULLSCREEN)
                        )
                        setOnMouseClicked {
                            primaryStage.isFullScreen = !primaryStage.isFullScreen
                        }
                    }
                    fontButton(Material2MZ.MINIMIZE, 20) {
                        setOnMouseClicked { primaryStage.isIconified = true }
                    }
                    fontButton(Material2AL.CLOSE, 20) {
                        setOnMouseClicked { primaryStage.close() }
                    }
                }
            }
        }
        stackpane {
            style {
                vgrow = Priority.ALWAYS
                hgrow = Priority.ALWAYS
            }
            if (savePath().value == null) {
                vbox(15, Pos.CENTER) {
                    label("Tabletop Simulator com.github.breadmoirai.ttsexplorer.model.Save Directory")
                    hbox(10, Pos.CENTER) {
                        textfield(savePath())
                        fontButton(Material2AL.FOLDER) {
                            onLeftClick {
                                FileChooser().showOpenDialog(scene.window)
                            }
                        }

                    }
                }
            }
        }
    }

    override fun onBeforeShow() {
        primaryStage.initStyle(StageStyle.TRANSPARENT)
        primaryStage.scene.fill = Color.TRANSPARENT
    }
}
