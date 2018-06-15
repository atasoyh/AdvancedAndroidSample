package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import io.reactivex.android.schedulers.AndroidSchedulers
import me.ibrahimyilmaz.advancedandroidsample.base.DisposableManager
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenScope
import javax.inject.Inject

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@ScreenScope
class TopHeadLinesPresenter @Inject constructor(private val viewModel: TopHeadLinesViewModel,
                                                private val repository: TopHeadLinesRepository, private val disposableManager: DisposableManager) {


    fun listArticles() = disposableManager.add(repository
            .listArticles().doOnError { t -> viewModel.onError(t) }
            .doOnSuccess { articles -> viewModel.onListArticle(articles) }
            .doOnSubscribe { viewModel.onLoading(true) }
//            .doOnEvent { t1, t2 -> viewModel.onLoading(false) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t -> }))

}