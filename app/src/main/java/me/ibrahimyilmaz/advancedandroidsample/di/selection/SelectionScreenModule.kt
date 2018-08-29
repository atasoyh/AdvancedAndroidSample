package me.ibrahimyilmaz.advancedandroidsample.di.selection

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import me.ibrahimyilmaz.advancedandroidsample.selection.SelectionScreen


/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@Module(subcomponents = [SelectionScreenSubComponent::class])
abstract class SelectionScreenModule {
    @Binds
    @IntoMap
    @FragmentKey(SelectionScreen::class)
    internal abstract fun bindSelectionScreenInjectorFactory(builder: SelectionScreenSubComponent.Builder): AndroidInjector.Factory<out Fragment>
}