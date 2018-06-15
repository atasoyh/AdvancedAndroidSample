package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.Single
import me.ibrahimyilmaz.advancedandroidsample.data.ArticleDao
import me.ibrahimyilmaz.newsitkotlin.model.Article
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@Singleton
class TopHeadLinesRepository @Inject
constructor(private val requester: TopHeadLinesRequester, private val appDao: ArticleDao, @Named("network_scheduler") val scheduler: Scheduler) {
    val articleList by lazy { mutableListOf<Article>() }

    fun listArticles(): Single<List<Article>> = Maybe.concat(memoryArticles(), apiArticles(), databaseArticles())
            .firstOrError().subscribeOn(scheduler)

    private fun apiArticles() = requester.listArticles().doOnSuccess { t ->
        appDao.apply { insert(t) }
    }.toMaybe()


    private fun memoryArticles() = Maybe.create<List<Article>> { emitter ->
        if (articleList.isNotEmpty())
            emitter.onSuccess(articleList)
        emitter.onComplete()
    }

    private fun databaseArticles() = appDao.listArticles()
            .filter { t -> t.isNotEmpty() }
            .doOnSuccess { t ->
                articleList.apply {
                    if (t.isEmpty())
                        throw Exception()

                    clear()
                    addAll(t)
                }
            }

}