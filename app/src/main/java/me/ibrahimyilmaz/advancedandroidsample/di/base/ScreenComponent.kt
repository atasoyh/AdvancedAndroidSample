package me.ibrahimyilmaz.advancedandroidsample.di.base

import dagger.android.AndroidInjector

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
interface ScreenComponent<T> : AndroidInjector<T> {
}