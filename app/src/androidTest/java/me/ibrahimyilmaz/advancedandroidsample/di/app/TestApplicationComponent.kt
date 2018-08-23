package me.ibrahimyilmaz.advancedandroidsample.di.app

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import me.ibrahimyilmaz.advancedandroidsample.base.TestDataModule
import me.ibrahimyilmaz.advancedandroidsample.base.TestNavigationModule
import me.ibrahimyilmaz.advancedandroidsample.base.TestNavigator
import me.ibrahimyilmaz.advancedandroidsample.di.base.NetworkModule
import me.ibrahimyilmaz.advancedandroidsample.di.main.MainActivityModule
import me.ibrahimyilmaz.advancedandroidsample.di.topheadlines.TopHeadLineFragmentModule
import me.ibrahimyilmaz.advancedandroidsample.di.topheadlines.TopHeadLinesFragmentModule
import me.ibrahimyilmaz.advancedandroidsample.topheadlines.TestTopHeadLinesService
import me.ibrahimyilmaz.advancedandroidsample.topheadlines.TestTopHeadLinesServiceModule
import me.ibrahimyilmaz.advancedandroidsample.topheadlines.TopHeadLinesRepository
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
            , (TestDataModule::class)
            , (TestNavigationModule::class)
            , (TestTopHeadLinesServiceModule::class)
            , (MainActivityModule::class)
            , (TopHeadLinesFragmentModule::class)
            , (TopHeadLineFragmentModule::class)
        ]
)
interface TestApplicationComponent : SampleApplicationComponent {


    fun topHeadLinesService(): TestTopHeadLinesService

    fun topHeadLinesRepository(): TopHeadLinesRepository

    fun testNavigator(): TestNavigator
}