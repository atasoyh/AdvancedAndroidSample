package me.ibrahimyilmaz.advancedandroidsample.di.base

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import me.ibrahimyilmaz.advancedandroidsample.data.AppDatabase
import javax.inject.Singleton

/**
 * Created by ibrahimyilmaz on 6/15/18 Project AdvancedAndroidSample.
 */
@Module
class DataModule {
    @Singleton
    @Provides
    fun appDatabase(context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "sampleappdb").build()

    @Singleton
    @Provides
    fun providesAppDao(appDatabase: AppDatabase) = appDatabase.articleDao()

}