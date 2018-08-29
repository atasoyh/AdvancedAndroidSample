package me.ibrahimyilmaz.advancedandroidsample.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import me.ibrahimyilmaz.advancedandroidsample.app.Home24TaskApplication

/**
 * Created by ibrahimyilmaz on 6/12/18 Project AdvancedAndroidSample.
 */
@Module
open class SampleApplicationModule(private val application: Home24TaskApplication) {

    @Provides
    fun providesContext(): Context = application.applicationContext
}