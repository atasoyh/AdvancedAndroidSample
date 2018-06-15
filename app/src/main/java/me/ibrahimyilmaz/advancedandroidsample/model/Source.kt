package me.ibrahimyilmaz.newsitkotlin.model

import android.arch.persistence.room.ColumnInfo
import android.support.annotation.Nullable
import com.squareup.moshi.Json

/**
 * Created by ibrahimyilmaz on 6/11/18 Project NewsItKotlin.
 */
data class Source(@Nullable @ColumnInfo(name = "source_id") @Json(name = "id") val id: String?,
                  @Nullable @ColumnInfo(name = "source_name") @Json(name = "name") val name: String?)