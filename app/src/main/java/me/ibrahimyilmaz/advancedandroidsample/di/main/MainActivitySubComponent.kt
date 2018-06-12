package me.ibrahimyilmaz.advancedandroidsample.di.main

import dagger.Subcomponent
import dagger.android.AndroidInjector
import me.ibrahimyilmaz.advancedandroidsample.app.ActivityScope
import me.ibrahimyilmaz.advancedandroidsample.main.MainActivity


/**
 * Created by ibrahimyilmaz on 6/12/18 Project AdvancedAndroidSample.
 */
@ActivityScope
@Subcomponent
interface MainActivitySubComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}