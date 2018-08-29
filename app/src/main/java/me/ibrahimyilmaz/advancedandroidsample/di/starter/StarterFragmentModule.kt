package me.ibrahimyilmaz.advancedandroidsample.di.starter

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import me.ibrahimyilmaz.advancedandroidsample.starter.StarterScreen

/**
 * Created by ibrahimyilmaz on 8/25/18 Project AdvancedAndroidSample.
 */
@Module(subcomponents = [StarterFragmentSubComponent::class])
abstract class StarterFragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(StarterScreen::class)
    internal abstract fun bindStarterFragmentInjectorFactory(builder: StarterFragmentSubComponent.Builder): AndroidInjector.Factory<out Fragment>

}