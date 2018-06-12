package me.ibrahimyilmaz.advancedandroidsample.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import me.ibrahimyilmaz.advancedandroidsample.app.SampleApplication

/**
 * Created by ibrahimyilmaz on 6/12/18 Project AdvancedAndroidSample.
 */
@Module
class SampleApplicationModule(private val application: SampleApplication) {

    @Provides
    fun providesContext(): Context = application.applicationContext
}