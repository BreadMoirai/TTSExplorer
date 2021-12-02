package com.github.breadmoirai.ttsexplorer.view

import com.github.breadmoirai.ttsexplorer.jfx.Preferences
import com.github.breadmoirai.ttsexplorer.jfx.toggleBinding
import com.github.breadmoirai.ttsexplorer.mfx.icon
import com.github.breadmoirai.ttsexplorer.mfx.label
import com.github.breadmoirai.ttsexplorer.mfx.raisedButton
import com.github.breadmoirai.ttsexplorer.mfx.textfield
import io.github.palexdev.materialfx.effects.DepthLevel
import javafx.geometry.Pos
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import javafx.stage.FileChooser
import javafx.stage.StageStyle
import org.kordamp.ikonli.javafx.FontIcon
import org.kordamp.ikonli.material2.Material2AL
import org.kordamp.ikonli.material2.Material2MZ
import tornadofx.*

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
                    icon(Material2AL.FULLSCREEN, 20) { icon ->
                        icon.iconCodeProperty().bind(
                            primaryStage.fullScreenProperty()
                                .toggleBinding(Material2AL.FULLSCREEN_EXIT, Material2AL.FULLSCREEN)
                        )
                        setOnMouseClicked {
                            primaryStage.isFullScreen = !primaryStage.isFullScreen
                        }
                    }
                    icon(Material2MZ.MINIMIZE, 20) {
                        setOnMouseClicked { primaryStage.isIconified = true }
                    }
                    icon(Material2AL.CLOSE, 20) {
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
            val saveDirPath = Preferences.saveDirPath(this@MainView)
//            if (saveDirPath.value == null) {
                vbox(15, Pos.CENTER) {
                    val label = label("Tabletop Simulator Save Directory") {
                        isAnimateLines = false
                        lineStrokeWidth = 0.0
                    }
                    hbox(10, Pos.CENTER) {
                        textfield {
                            style {
                                prefWidth = 500.px
                            }
                            label.focusedProperty().onChange { focused ->
                                if (focused) this.requestFocus()
                            }
                        }
                        raisedButton(graphic = FontIcon(Material2AL.FOLDER)) {
                            style {
                                backgroundColor = multi(Color.WHITESMOKE)
                                depthLevel = DepthLevel.LEVEL5
                            }
                            onLeftClick {
                                FileChooser().showOpenDialog(scene.window)
                            }
                        }
                    }
//                }
            }
        }
    }

    override fun onBeforeShow() {
        primaryStage.initStyle(StageStyle.TRANSPARENT)
        primaryStage.scene.fill = Color.TRANSPARENT
    }
}
