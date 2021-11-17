package com.github.breadmoirai.ttsexplorer.mfx

import io.github.palexdev.materialfx.controls.MFXButton
import io.github.palexdev.materialfx.controls.MFXIconWrapper
import io.github.palexdev.materialfx.controls.MFXLabel
import javafx.event.EventTarget
import javafx.scene.Node
import org.kordamp.ikonli.Ikon
import org.kordamp.ikonli.javafx.FontIcon
import tornadofx.addClass
import tornadofx.attachTo

fun EventTarget.fontButton(
    icon: Ikon,
    iconSize: Int = 16,
    buttonSize: Number = 22,
    op: (MFXIconWrapper).(FontIcon) -> Unit = {}
): MFXIconWrapper {
    val fontIcon = FontIcon(icon)
    fontIcon.iconSize = iconSize
    return MFXIconWrapper(fontIcon, buttonSize.toDouble()).attachTo(this) { op(this, fontIcon) }
}

fun EventTarget.label(text: String = "", op: MFXLabel.() -> Unit = {}) = MFXLabel(text).attachTo(this, op)

fun EventTarget.button(text: String = "", graphic: Node? = null, op: MFXButton.() -> Unit = {}) =
    MFXButton(text).attachTo(this, op) {
        if (graphic != null) it.graphic = graphic
    }

fun EventTarget.flatButton(text: String = "", graphic: Node? = null, op: MFXButton.() -> Unit = {}) =
    MFXButton(text).addClass("flat-button").attachTo(this, op) {
        if (graphic != null) it.graphic = graphic
    }

fun EventTarget.raisedButton(text: String = "", graphic: Node? = null, op: MFXButton.() -> Unit = {}) =
    MFXButton(text).addClass("raised-button").attachTo(this, op) {
        if (graphic != null) it.graphic = graphic
    }