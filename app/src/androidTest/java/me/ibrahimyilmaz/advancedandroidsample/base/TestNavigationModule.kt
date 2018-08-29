package me.ibrahimyilmaz.advancedandroidsample.base

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by ibrahimyilmaz on 8/23/18 Project AdvancedAndroidSample.
 */
@Module
abstract class TestNavigationModule {

    @Binds
    abstract fun provideNavigator(navigator: TestNavigator): Navigator
}