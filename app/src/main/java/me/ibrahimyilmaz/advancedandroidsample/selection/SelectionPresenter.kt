package me.ibrahimyilmaz.advancedandroidsample.selection

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiConsumer
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.base.DisposableManager
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenScope
import me.ibrahimyilmaz.newsitkotlin.model.Article
import javax.inject.Inject

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@ScreenScope
class SelectionPresenter @Inject constructor(private val viewModel: SelectionViewModel,
                                             private val repository: ArticlesRepository, private val disposableManager: DisposableManager) {

    init {
        //when Starter Screen is appear list articles
        listArticles()
    }

    private fun handleArticles(articles: List<Article>): SelectArticleState {
        val currentIndex = articles.indexOfFirst { article -> !article.rated() }
        val likedArticleCount = articles.count { article -> article.liked() }
        val status = if (currentIndex == -1) SelectScreenStatus.ON_FINISHED else SelectScreenStatus.ON_SUCCESS
        return SelectArticleState(status = status, messageId = if (status == SelectScreenStatus.ON_FINISHED) R.string.message_all_articles_rated else R.string.none, articles = articles, currentIndex = currentIndex, likedArticleCount = likedArticleCount)
    }

    fun listArticles() {
        viewModel.onArticleEvent().accept(SelectArticleState(status = SelectScreenStatus.ON_LOADING))
        disposableManager.add(
                repository
                        .listArticles()
                        .doOnSuccess { it -> viewModel.onArticleEvent().accept(handleArticles(it)) }
                        .doOnSubscribe { }
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnError { _ ->
                            viewModel.onArticleEvent().accept(SelectArticleState(status = SelectScreenStatus.ON_ERROR, messageId = R.string.error_on_network_loading))
                        }
                        .subscribe(BiConsumer { _, _ -> }))
    }

    fun rateArticle(rateStatus: RateStatus) {
        disposableManager.add(repository
                .rateArticle(rateStatus)
                .doOnSuccess { t -> viewModel.onArticleEvent().accept(handleArticles(t)) }
                .doOnSubscribe { }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { }
                .subscribe(BiConsumer { _, _ -> }))

    }
}