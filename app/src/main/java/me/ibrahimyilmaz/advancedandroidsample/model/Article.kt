package me.ibrahimyilmaz.newsitkotlin.model

import android.support.annotation.Nullable
import com.squareup.moshi.Json
import org.threeten.bp.ZonedDateTime

/**
 * Created by ibrahimyilmaz on 6/11/18 Project NewsItKotlin.
 */
open class Article(@Nullable @Json(name = "source") val source: Source,
                   @Nullable @Json(name = "author") val author: String,
                   @Nullable @Json(name = "title") val title: String,
                   @Nullable @Json(name = "description") val description: String,
                   @Nullable @Json(name = "url") val url: String,
                   @Nullable @Json(name = "urlToImage") val urlToImage: String,
                   @Nullable @Json(name = "publishedAt") val publishedAt: ZonedDateTime
)