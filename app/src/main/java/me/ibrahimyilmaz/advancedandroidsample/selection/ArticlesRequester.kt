package me.ibrahimyilmaz.advancedandroidsample.selection

import io.reactivex.Single
import me.ibrahimyilmaz.advancedandroidsample.service.Home24ArticleService
import me.ibrahimyilmaz.newsitkotlin.model.Article
import javax.inject.Inject


class ArticlesRequester @Inject constructor(private val service: Home24ArticleService) {

    fun listArticles(appDomain: Int = 1, locale: String = "de_DE", limit: Int = 10, offset: Int? = null): Single<List<Article>> {
        return service.listArticles(HashMap<String, String>().apply {
            put("appDomain", appDomain.toString())
            put("locale", locale)
            put("limit", limit.toString())
            if (offset != null)
                put("offset", offset.toString())
        }).map { articlesResponse ->
            val articles = if (articlesResponse._embedded?.articles == null || articlesResponse._embedded.articles.isEmpty()) listOf() else articlesResponse._embedded.articles
            articles
        }
    }
}