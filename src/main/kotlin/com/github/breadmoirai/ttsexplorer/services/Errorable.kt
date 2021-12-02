package com.github.breadmoirai.ttsexplorer.services

interface IErrorable {
    val error: String
    val hasError: Boolean
}

class Errorable : IErrorable, (String) -> Unit {
    private var _error: String? = null
    override val error: String
        get() = _error!!
    override val hasError: Boolean
        get() = _error != null

    override fun invoke(error: String) {
        _error = error
    }

}