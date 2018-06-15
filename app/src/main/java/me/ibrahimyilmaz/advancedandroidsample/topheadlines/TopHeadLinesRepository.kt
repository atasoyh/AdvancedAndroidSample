package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.Single
import me.ibrahimyilmaz.newsitkotlin.model.Article
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@Singleton
class TopHeadLinesRepository @Inject
constructor(private val requester: TopHeadLinesRequester, @Named("network_scheduler") val scheduler: Scheduler) {
    val articleList by lazy { mutableListOf<Article>() }

    fun listArticles(): Single<List<Article>> = Maybe.concat(memoryArticles(), apiArticles())
            .firstOrError().subscribeOn(scheduler)

    private fun apiArticles() = requester.listArticles().doOnSuccess { t ->
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
}