package me.ibrahimyilmaz.advancedandroidsample.selection

import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleEmitter
import me.ibrahimyilmaz.newsitkotlin.model.Article
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class ArticlesRepository @Inject
constructor(private val requester: ArticlesRequester, @Named("network_scheduler") val scheduler: Scheduler) {
    private val articleList by lazy { mutableListOf<Article>() }
    fun listArticles(): Single<List<Article>> = Maybe.concat(memoryArticles(), apiArticles())
            .firstOrError().subscribeOn(scheduler)

    private fun apiArticles(): Maybe<List<Article>> = requester.listArticles()
            .doOnSuccess { t ->
                articleList.apply {
                    clear()
                    addAll(t)
                }
            }.toMaybe()


    private fun memoryArticles() = Maybe.create<List<Article>> { emitter ->
        if (articleList.isNotEmpty())
            emitter.onSuccess(articleList)
        emitter.onComplete()
    }


    fun rateArticle(rateStatus: RateStatus = RateStatus.LIKE): Single<List<Article>> {

        val lastUnratedIndex = articleList.indexOfFirst { article -> !article.rated() }
        if (lastUnratedIndex != -1) {
            articleList[lastUnratedIndex].rateStatus = rateStatus
        }

        return Single.create<List<Article>> { emitter: SingleEmitter<List<Article>> -> emitter.onSuccess(articleList) }

    }

    fun clearCache() {
        articleList.clear()
    }

}