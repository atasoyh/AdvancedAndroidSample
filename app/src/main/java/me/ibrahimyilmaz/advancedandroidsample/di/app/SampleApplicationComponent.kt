package me.ibrahimyilmaz.advancedandroidsample.di.app

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import me.ibrahimyilmaz.advancedandroidsample.app.Home24TaskApplication
import me.ibrahimyilmaz.advancedandroidsample.di.base.NavigationModule
import me.ibrahimyilmaz.advancedandroidsample.di.base.NetworkModule
import me.ibrahimyilmaz.advancedandroidsample.di.main.MainActivityModule
import me.ibrahimyilmaz.advancedandroidsample.di.review.ReviewScreenModule
import me.ibrahimyilmaz.advancedandroidsample.di.selection.SelectionScreenModule
import me.ibrahimyilmaz.advancedandroidsample.di.service.ServiceModule
import me.ibrahimyilmaz.advancedandroidsample.di.starter.StarterFragmentModule
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
    (ServiceModule::class),
    (MainActivityModule::class),
    (SelectionScreenModule::class),
    (StarterFragmentModule::class),
    (ReviewScreenModule::class)
])
interface SampleApplicationComponent {
    fun inject(application: Home24TaskApplication)
}