package me.ibrahimyilmaz.advancedandroidsample.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
class DisposableManager : LifecycleObserver {
    val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun add(disposables: Disposable) =
            compositeDisposable.add(disposables)

    fun addAll(disposables: List<Disposable>) = disposables.forEach {
        compositeDisposable.add(it)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clear() = compositeDisposable.clear()
}