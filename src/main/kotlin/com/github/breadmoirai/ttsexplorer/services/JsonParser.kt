package com.github.breadmoirai.ttsexplorer.services

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okio.buffer
import okio.source
import java.io.File

object JsonParser {
    val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    @OptIn(ExperimentalStdlibApi::class)
    inline fun <reified T> File.parse(): T {
        return moshi.adapter<T>().fromJson(this.source().buffer())
    }
}