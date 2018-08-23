package me.ibrahimyilmaz.advancedandroidsample.di.topheadlines

import dagger.Subcomponent
import dagger.android.AndroidInjector
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenComponent
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenModule
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenScope
import me.ibrahimyilmaz.advancedandroidsample.topheadline.TopHeadLineFragment

/**
 * Created by ibrahimyilmaz on 8/12/18 Project AdvancedAndroidSample.
 */

@ScreenScope
@Subcomponent(modules = [ScreenModule::class])
interface TopHeadLineFragmentSubComponent : ScreenComponent<TopHeadLineFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TopHeadLineFragment>()
}