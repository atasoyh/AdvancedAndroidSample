package me.ibrahimyilmaz.advancedandroidsample.di.starter

import dagger.Subcomponent
import dagger.android.AndroidInjector
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenComponent
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenModule
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenScope
import me.ibrahimyilmaz.advancedandroidsample.starter.StarterScreen

@ScreenScope
@Subcomponent(modules = [ScreenModule::class])
interface StarterFragmentSubComponent : ScreenComponent<StarterScreen> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<StarterScreen>()
}

