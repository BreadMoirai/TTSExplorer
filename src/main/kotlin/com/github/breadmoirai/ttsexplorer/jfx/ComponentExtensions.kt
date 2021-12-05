package com.github.breadmoirai.ttsexplorer.jfx

import javafx.event.EventTarget
import org.kordamp.ikonli.Ikon
import org.kordamp.ikonli.javafx.FontIcon
import tornadofx.*

fun EventTarget.icon(iconCode: Ikon, op: FontIcon.() -> Unit = {}) = FontIcon(iconCode).attachTo(this, op)
