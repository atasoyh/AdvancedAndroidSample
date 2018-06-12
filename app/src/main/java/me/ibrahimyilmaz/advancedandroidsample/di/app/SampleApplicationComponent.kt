package me.ibrahimyilmaz.advancedandroidsample.di.app

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import me.ibrahimyilmaz.advancedandroidsample.app.SampleApplication
import me.ibrahimyilmaz.advancedandroidsample.di.main.MainActivityModule
import me.ibrahimyilmaz.advancedandroidsample.di.topheadlines.TopHeadLinesFragmentModule
import javax.inject.Singleton

/**
 * Created by ibrahimyilmaz on 6/12/18 Project AdvancedAndroidSample.
 */
@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (SampleApplicationModule::class),
    (MainActivityModule::class),
    (TopHeadLinesFragmentModule::class)
])
interface SampleApplicationComponent {
    fun inject(application: SampleApplication)
}