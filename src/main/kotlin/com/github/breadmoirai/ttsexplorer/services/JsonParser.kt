package com.github.breadmoirai.ttsexplorer.services

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import javafx.concurrent.Task
import okio.buffer
import okio.source
import tornadofx.*
import java.io.File

object JsonParser {
    val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()!!

    @OptIn(ExperimentalStdlibApi::class)
    inline fun <reified T> File.parse(): Task<T?> {
        return runAsync {
            return@runAsync moshi.adapter<T>().fromJson(this@parse.source().buffer())
        }
    }
}