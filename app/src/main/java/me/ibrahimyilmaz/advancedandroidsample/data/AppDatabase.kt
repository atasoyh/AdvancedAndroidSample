package me.ibrahimyilmaz.advancedandroidsample.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import me.ibrahimyilmaz.advancedandroidsample.model.ZonedDateTimeConverter
import me.ibrahimyilmaz.newsitkotlin.model.Article

/**
 * Created by ibrahimyilmaz on 6/15/18 Project AdvancedAndroidSample.
 */
@Database(entities = [Article::class], version = 1)
@TypeConverters(value = [ZonedDateTimeConverter::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}