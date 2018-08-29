package me.ibrahimyilmaz.advancedandroidsample.di.selection

import dagger.Subcomponent
import dagger.android.AndroidInjector
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenComponent
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenModule
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenScope
import me.ibrahimyilmaz.advancedandroidsample.selection.SelectionScreen


@ScreenScope
@Subcomponent(modules = [ScreenModule::class])
interface SelectionScreenSubComponent : ScreenComponent<SelectionScreen> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SelectionScreen>()
}