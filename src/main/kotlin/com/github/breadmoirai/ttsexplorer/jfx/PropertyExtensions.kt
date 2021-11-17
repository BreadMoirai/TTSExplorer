package com.github.breadmoirai.ttsexplorer.jfx

import javafx.beans.binding.Binding
import javafx.beans.property.ReadOnlyBooleanProperty
import tornadofx.nonNullObjectBinding

fun <T> ReadOnlyBooleanProperty.toggleBinding(ifTrue: T, ifFalse: T): Binding<T> = nonNullObjectBinding(this) {
    if (this.value) ifTrue else ifFalse
}