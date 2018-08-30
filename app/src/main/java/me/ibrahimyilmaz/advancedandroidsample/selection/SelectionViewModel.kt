package me.ibrahimyilmaz.advancedandroidsample.selection

import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenScope
import javax.inject.Inject

/**
 * Created by ibrahimyilmaz on 8/25/18 Project AdvancedAndroidSample.
 */
@ScreenScope
class SelectionViewModel @Inject constructor() {

    private val selectArticleState: BehaviorRelay<SelectArticleState> = BehaviorRelay.create()

    fun selectArticleState(): Observable<SelectArticleState> {
        return selectArticleState
    }

    fun onSelectArticleState(): Consumer<SelectArticleState> {
        return selectArticleState
    }

}