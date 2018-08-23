package me.ibrahimyilmaz.advancedandroidsample.di.app

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import me.ibrahimyilmaz.advancedandroidsample.app.SampleApplication
import me.ibrahimyilmaz.advancedandroidsample.di.base.DataModule
import me.ibrahimyilmaz.advancedandroidsample.di.base.NavigationModule
import me.ibrahimyilmaz.advancedandroidsample.di.base.NetworkModule
import me.ibrahimyilmaz.advancedandroidsample.di.main.MainActivityModule
import me.ibrahimyilmaz.advancedandroidsample.di.topheadlines.TopHeadLineFragmentModule
import me.ibrahimyilmaz.advancedandroidsample.di.topheadlines.TopHeadLinesFragmentModule
import me.ibrahimyilmaz.advancedandroidsample.di.topheadlines.TopHeadLinesServiceModule
import javax.inject.Singleton

/**
 * Created by ibrahimyilmaz on 6/12/18 Project AdvancedAndroidSample.
 */
@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (SampleApplicationModule::class),
    (NetworkModule::class),
    (NavigationModule::class),
    (DataModule::class),
    (TopHeadLinesServiceModule::class),
    (MainActivityModule::class),
    (TopHeadLinesFragmentModule::class),
    (TopHeadLineFragmentModule::class)
])
interface SampleApplicationComponent {
    fun inject(application: SampleApplication)
}