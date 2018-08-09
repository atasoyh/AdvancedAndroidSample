package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiConsumer
import me.ibrahimyilmaz.advancedandroidsample.base.DisposableManager
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenScope
import javax.inject.Inject

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@ScreenScope
class TopHeadLinesPresenter @Inject constructor(private val viewModel: TopHeadLinesViewModel,
                                                private val repository: TopHeadLinesRepository, private val disposableManager: DisposableManager) {


    fun listArticles() = disposableManager.add(
            repository
                    .listArticles()
                    .doOnSuccess { articles -> viewModel.onListArticle(articles) }
                    .doOnSubscribe { viewModel.onLoading(true) }
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError({ t -> viewModel.onError(t) })
                    .subscribe(BiConsumer { _, _ -> }))

}