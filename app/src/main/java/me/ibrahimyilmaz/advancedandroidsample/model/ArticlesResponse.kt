package me.ibrahimyilmaz.newsitkotlin.model

import com.squareup.moshi.Json

open class Embedded(
        @Json(name = "articles") val articles: List<Article>?
)

open class ArticlesResponse(
        @Json(name = "_embedded") val _embedded: Embedded?
)




