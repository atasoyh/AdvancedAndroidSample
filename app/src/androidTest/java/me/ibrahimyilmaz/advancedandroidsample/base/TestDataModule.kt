package me.ibrahimyilmaz.advancedandroidsample.base

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import me.ibrahimyilmaz.advancedandroidsample.data.AppDatabase
import javax.inject.Singleton

/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
@Module
class TestDataModule {
    @Singleton
    @Provides
    fun appDatabase(context: Context) = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun providesAppDao(appDatabase: AppDatabase) = appDatabase.articleDao()

}