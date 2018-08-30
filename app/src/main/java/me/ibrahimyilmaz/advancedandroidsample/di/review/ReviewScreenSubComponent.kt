package me.ibrahimyilmaz.advancedandroidsample.di.review

import dagger.Subcomponent
import dagger.android.AndroidInjector
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenComponent
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenModule
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenScope
import me.ibrahimyilmaz.advancedandroidsample.review.ReviewScreen
import me.ibrahimyilmaz.advancedandroidsample.selection.SelectionScreen


@ScreenScope
@Subcomponent(modules = [ScreenModule::class])
interface ReviewScreenSubComponent : ScreenComponent<ReviewScreen> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ReviewScreen>()
}