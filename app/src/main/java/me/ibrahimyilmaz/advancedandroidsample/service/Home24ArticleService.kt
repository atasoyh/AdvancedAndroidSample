package me.ibrahimyilmaz.advancedandroidsample.service

import io.reactivex.Single
import me.ibrahimyilmaz.newsitkotlin.model.ArticlesResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap


/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
interface Home24ArticleService {
    @GET("articles")
    fun listArticles(@QueryMap options: Map<String, String>): Single<ArticlesResponse>
}