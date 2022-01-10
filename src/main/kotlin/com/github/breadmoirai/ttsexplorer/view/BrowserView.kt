package com.github.breadmoirai.ttsexplorer.view

import tornadofx.*

class BrowserView: View("Browser") {
    override val root = borderpane {
        center {
            label("List of files")
        }
    }
}