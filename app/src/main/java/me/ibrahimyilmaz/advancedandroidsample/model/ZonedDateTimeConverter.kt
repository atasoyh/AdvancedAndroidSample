package me.ibrahimyilmaz.advancedandroidsample.model

import android.arch.persistence.room.TypeConverter
import org.threeten.bp.ZonedDateTime

/**
 * Created by ibrahimyilmaz on 6/15/18 Project AdvancedAndroidSample.
 */
object ZonedDateTimeConverter {

    @JvmStatic
    @TypeConverter
    fun toZonedDateTime(time: String): ZonedDateTime = ZonedDateTime.parse(time)

    @JvmStatic
    @TypeConverter
    fun fromZonedDateTime(zonedDateTime: ZonedDateTime): String = zonedDateTime.toString()
}