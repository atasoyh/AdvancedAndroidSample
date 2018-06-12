package me.ibrahimyilmaz.advancedandroidsample.di.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.ibrahimyilmaz.advancedandroidsample.app.ActivityScope
import me.ibrahimyilmaz.advancedandroidsample.main.MainActivity


/**
 * Created by ibrahimyilmaz on 6/12/18 Project AdvancedAndroidSample.
 */
@Module
abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf())
    abstract fun contributeMainActivity(): MainActivity
}