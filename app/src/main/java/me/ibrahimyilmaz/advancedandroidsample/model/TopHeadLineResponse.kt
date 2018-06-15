package me.ibrahimyilmaz.newsitkotlin.model

import com.squareup.moshi.Json

/**
 * Created by ibrahimyilmaz on 6/11/18 Project NewsItKotlin.
 */
open class TopHeadLineResponse(
        @Json(name = "status") val status: Status,
        @Json(name = "errorCode") val errorCode: ErrorCode,
        @Json(name = "message") val message: String,
        @Json(name = "totalResults") val totalResults: Int,
        @Json(name = "articles") val articles: List<Article>
)