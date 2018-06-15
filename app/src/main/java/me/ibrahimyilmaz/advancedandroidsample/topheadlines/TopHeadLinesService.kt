package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import io.reactivex.Single
import me.ibrahimyilmaz.newsitkotlin.model.TopHeadLineResponse
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
interface TopHeadLinesService {
    @GET("top-headlines/")
    fun listTopHeadLines(@Query("country") country: String): Single<TopHeadLineResponse>
}