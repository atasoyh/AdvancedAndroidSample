package me.ibrahimyilmaz.advancedandroidsample.di.topheadlines

import dagger.Subcomponent
import dagger.android.AndroidInjector
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenComponent
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenModule
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenScope
import me.ibrahimyilmaz.advancedandroidsample.topheadlines.TopHeadLinesFragment


/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@ScreenScope
@Subcomponent(modules = [ScreenModule::class])
interface TopHeadLinesFragmentSubComponent : ScreenComponent<TopHeadLinesFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TopHeadLinesFragment>()
}