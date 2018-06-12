package me.ibrahimyilmaz.advancedandroidsample.di.topheadlines

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import me.ibrahimyilmaz.advancedandroidsample.topheadlines.TopHeadLinesFragment


/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@Module(subcomponents = [TopHeadLinesFragmentSubComponent::class])
abstract class TopHeadLinesFragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(TopHeadLinesFragment::class)
    internal abstract fun bindYourFragmentInjectorFactory(builder: TopHeadLinesFragmentSubComponent.Builder): AndroidInjector.Factory<out Fragment>
}