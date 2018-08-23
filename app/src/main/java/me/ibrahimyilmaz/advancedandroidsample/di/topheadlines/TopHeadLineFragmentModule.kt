package me.ibrahimyilmaz.advancedandroidsample.di.topheadlines

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import me.ibrahimyilmaz.advancedandroidsample.topheadline.TopHeadLineFragment

/**
 * Created by ibrahimyilmaz on 8/12/18 Project AdvancedAndroidSample.
 */

@Module(subcomponents = [TopHeadLineFragmentSubComponent::class])
abstract class TopHeadLineFragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(TopHeadLineFragment::class)
    internal abstract fun bindYourFragmentInjectorFactory(builder: TopHeadLineFragmentSubComponent.Builder): AndroidInjector.Factory<out Fragment>
}