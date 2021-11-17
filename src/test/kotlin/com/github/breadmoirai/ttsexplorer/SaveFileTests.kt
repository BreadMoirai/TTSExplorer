package com.github.breadmoirai.ttsexplorer

import com.github.breadmoirai.ttsexplorer.model.Save
import com.github.breadmoirai.ttsexplorer.model.WorkshopFileInfo
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okio.buffer
import okio.source
import org.junit.experimental.theories.DataPoint
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import java.io.File
import kotlin.test.Test
import kotlin.test.assertNotNull


private fun Any.getSaveFile(path: String): File {
    return File(this.javaClass.classLoader.getResource(path)!!.toURI())
}

@ExperimentalStdlibApi
@RunWith(Theories::class)
class SaveFileTests {
    companion object {
        @DataPoint("savefile")
        const val STARDEW_VALLEY = "Tabletop Simulator/Mods/Workshop/2420526947.json"

        @DataPoint("savefile")
        const val MIDDARA = "Tabletop Simulator/Mods/Workshop/2016593204.json"

        const val WORKSHOP_FILE_INFO = "Tabletop Simulator/Mods/Workshop/WorkshopFileInfos.json"
    }

    @Theory
    fun `parse a save file`(savefile: String) {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val save = moshi
            .adapter<Save>()
            .failOnUnknown()
            .fromJson(getSaveFile(savefile).source().buffer())!!
        assertNotNull(save)
    }

    @Test
    fun `parse workshop info file`() {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val list = moshi
            .adapter<List<WorkshopFileInfo>>()
            .failOnUnknown()
            .fromJson(getSaveFile(WORKSHOP_FILE_INFO).source().buffer())!!
        assertNotNull(list)
        println("list.size = ${list.size}")
        val set = list.toSet()
        println("list.toSet().size = ${set.size}")
        for (info in set) {
            assert(set.all { info === it || info.name != it.name  }) { "Found duplicate entry in set"}
        }
    }

}