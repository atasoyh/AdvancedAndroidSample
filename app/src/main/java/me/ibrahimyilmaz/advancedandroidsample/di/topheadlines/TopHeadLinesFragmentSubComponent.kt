package me.ibrahimyilmaz.advancedandroidsample.di.topheadlines

import dagger.Subcomponent
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenComponent
import me.ibrahimyilmaz.advancedandroidsample.topheadlines.TopHeadLinesFragment
import dagger.android.AndroidInjector



/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@Subcomponent
interface TopHeadLinesFragmentSubComponent : ScreenComponent<TopHeadLinesFragment> {
    @Subcomponent.Builder
    abstract  class Builder : AndroidInjector.Builder<TopHeadLinesFragment>()
}