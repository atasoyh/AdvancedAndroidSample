package me.ibrahimyilmaz.newsitkotlin.model

import android.support.annotation.Nullable
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.threeten.bp.ZonedDateTime


/**
 * Created by ibrahimyilmaz on 6/11/18 Project NewsItKotlin.
 */
class ZonedDateTimeAdapter {
    @FromJson
    fun fromJson(json: String): ZonedDateTime {
        return ZonedDateTime.parse(json)
    }

    @ToJson
    fun toJson(@Nullable value: ZonedDateTime?): String? {
        return value?.toString()
    }
}