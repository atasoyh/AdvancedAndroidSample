package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenScope
import me.ibrahimyilmaz.newsitkotlin.model.Article
import javax.inject.Inject

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@ScreenScope
class TopHeadLinesViewModel @Inject constructor() : ViewModel() {

    val state: MutableLiveData<TopHeadLinesState> by lazy {
        MutableLiveData<TopHeadLinesState>()
    }

    fun onError(throwable: Throwable) {
        val message = throwable.message ?: "error"
        state.postValue(TopHeadLinesState(errorMessage = message))
    }

    fun onLoading(boolean: Boolean) = state.postValue(TopHeadLinesState(loading = boolean))
    fun onListArticle(articles: List<Article>) = state.postValue(TopHeadLinesState(articles = articles))
}