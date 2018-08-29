package me.ibrahimyilmaz.advancedandroidsample.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
class DisposableManager {
    val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun add(disposables: Disposable) {
        compositeDisposable.add(disposables)
    }

    fun addAll(disposables: List<Disposable>) {
        disposables.forEach {
            compositeDisposable.add(it)
        }
    }

    fun clear() {
        compositeDisposable.clear()
    }
}