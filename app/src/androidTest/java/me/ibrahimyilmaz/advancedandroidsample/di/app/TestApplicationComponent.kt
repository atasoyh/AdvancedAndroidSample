package me.ibrahimyilmaz.advancedandroidsample.di.app

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import me.ibrahimyilmaz.advancedandroidsample.base.TestNavigationModule
import me.ibrahimyilmaz.advancedandroidsample.base.TestNavigator
import me.ibrahimyilmaz.advancedandroidsample.di.base.NetworkModule
import me.ibrahimyilmaz.advancedandroidsample.di.main.MainActivityModule
import me.ibrahimyilmaz.advancedandroidsample.di.starter.StarterFragmentModule
import me.ibrahimyilmaz.advancedandroidsample.di.selection.SelectionScreenModule
import me.ibrahimyilmaz.advancedandroidsample.selection.ArticlesRepository
import me.ibrahimyilmaz.advancedandroidsample.service.Home24ServiceModule
import me.ibrahimyilmaz.advancedandroidsample.service.TestHome24ArticleService
import javax.inject.Singleton

/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
@Singleton
@Component(
        modules = [
            (AndroidSupportInjectionModule::class)
            , (SampleApplicationModule::class)
            , (NetworkModule::class)
            , (TestNavigationModule::class)
            , (Home24ServiceModule::class)
            , (MainActivityModule::class)
            , (SelectionScreenModule::class)
            , (StarterFragmentModule::class)
        ]
)
interface TestApplicationComponent : SampleApplicationComponent {


    fun topHeadLinesService(): TestHome24ArticleService

    fun topHeadLinesRepository(): ArticlesRepository

    fun testNavigator(): TestNavigator
}