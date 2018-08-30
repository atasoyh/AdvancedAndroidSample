package me.ibrahimyilmaz.advancedandroidsample.di.review

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import me.ibrahimyilmaz.advancedandroidsample.review.ReviewScreen

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@Module(subcomponents = [ReviewScreenSubComponent::class])
abstract class ReviewScreenModule {
    @Binds
    @IntoMap
    @FragmentKey(ReviewScreen::class)
    internal abstract fun bindReviewScreenInjectorFactory(builder: ReviewScreenSubComponent.Builder): AndroidInjector.Factory<out Fragment>
}