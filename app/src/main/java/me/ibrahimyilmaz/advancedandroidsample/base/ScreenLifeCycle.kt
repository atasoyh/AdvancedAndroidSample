package me.ibrahimyilmaz.advancedandroidsample.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

/**
 * Created by ibrahimyilmaz on 8/25/18 Project AdvancedAndroidSample.
 */
interface ScreenLifeCycle : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun enterScope()

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun exitScope()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy()
}