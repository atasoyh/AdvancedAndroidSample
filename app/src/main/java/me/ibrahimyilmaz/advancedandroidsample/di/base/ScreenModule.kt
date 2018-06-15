package me.ibrahimyilmaz.advancedandroidsample.di.base

import dagger.Module
import dagger.Provides
import me.ibrahimyilmaz.advancedandroidsample.base.DisposableManager

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@Module
object ScreenModule {
    @ScreenScope
    @JvmStatic
    @Provides
    fun providesDisposableManager() = DisposableManager()
}