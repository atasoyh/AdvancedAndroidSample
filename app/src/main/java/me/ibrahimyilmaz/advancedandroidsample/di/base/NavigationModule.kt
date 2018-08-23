package me.ibrahimyilmaz.advancedandroidsample.di.base

import dagger.Module
import dagger.Provides
import me.ibrahimyilmaz.advancedandroidsample.base.DefaultNavigator
import me.ibrahimyilmaz.advancedandroidsample.base.Navigator
import javax.inject.Singleton

/**
 * Created by ibrahimyilmaz on 8/23/18 Project AdvancedAndroidSample.
 */
@Module
open class NavigationModule {

    @Singleton
    @Provides
    open fun provideNavigator(): Navigator = DefaultNavigator()
}