package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import me.ibrahimyilmaz.newsitkotlin.model.Article

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
data class TopHeadLinesState(val loading: Boolean = false,
                             val errorMessage: String = "",
                             val articles: List<Article> = listOf())