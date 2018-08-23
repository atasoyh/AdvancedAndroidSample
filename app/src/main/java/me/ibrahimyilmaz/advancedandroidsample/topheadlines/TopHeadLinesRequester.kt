package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import me.ibrahimyilmaz.newsitkotlin.model.Status
import me.ibrahimyilmaz.newsitkotlin.model.TopHeadLineResponse
import javax.inject.Inject

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
class TopHeadLinesRequester @Inject constructor(private val service: TopHeadLinesService) {

    fun listArticles() = service.listTopHeadLines("tr")
            .map { response: TopHeadLineResponse ->
                when (response.status) {
                    Status.ok -> response.articles
                    Status.error -> throw Throwable(message = response.message)
                }
            }.doOnError({ _ -> })
}