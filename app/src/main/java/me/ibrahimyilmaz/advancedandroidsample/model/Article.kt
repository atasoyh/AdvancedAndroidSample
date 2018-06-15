package me.ibrahimyilmaz.newsitkotlin.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.Nullable
import com.squareup.moshi.Json
import org.threeten.bp.ZonedDateTime


/**
 * Created by ibrahimyilmaz on 6/11/18 Project NewsItKotlin.
 */
@Entity
data class Article(
        @PrimaryKey(autoGenerate = true) val id: Int? = null,
        @Nullable @Embedded @Json(name = "source") val source: Source?,
        @Nullable @ColumnInfo(name = "author") @Json(name = "author") val author: String?,
        @Nullable @ColumnInfo(name = "title") @Json(name = "title") val title: String?,
        @Nullable @ColumnInfo(name = "description") @Json(name = "description") val description: String?,
        @Nullable @ColumnInfo(name = "url") @Json(name = "url") val url: String?,
        @Nullable @ColumnInfo(name = "urlToImage") @Json(name = "urlToImage") val urlToImage: String?,
        @Nullable @ColumnInfo(name = "publishedAt") @Json(name = "publishedAt") val publishedAt: ZonedDateTime?
) {


}

