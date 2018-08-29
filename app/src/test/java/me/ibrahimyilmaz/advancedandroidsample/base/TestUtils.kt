package me.ibrahimyilmaz.advancedandroidsample.base

import com.squareup.moshi.Moshi
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Type


/**
 * Created by ibrahimyilmaz on 8/1/18 Project AdvancedAndroidSample.
 */

open class TestUtils {

    val moshi by lazy {
        Moshi.Builder().build()
    }

    fun <T> loadJson(path: String, type: Type) = moshi.adapter<T>(type).fromJson(getFileString(path))

    fun <T> loadJson(path: String, clazz: Class<T>) = moshi.adapter(clazz).fromJson(getFileString(path))

    private fun getFileString(path: String) = BufferedReader(InputStreamReader(
            javaClass.classLoader.getResourceAsStream(path))).use(BufferedReader::readText)


}