package me.ibrahimyilmaz.newsitkotlin.model

import android.support.annotation.Nullable
import com.squareup.moshi.Json

/**
 * Created by ibrahimyilmaz on 6/11/18 Project NewsItKotlin.
 */
data class Source(@Nullable @Json(name = "id") val id: String,
                  @Nullable @Json(name = "name") val name: String)