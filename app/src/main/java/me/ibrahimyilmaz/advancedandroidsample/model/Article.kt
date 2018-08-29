package me.ibrahimyilmaz.newsitkotlin.model

import android.support.annotation.Nullable
import me.ibrahimyilmaz.advancedandroidsample.selection.RateStatus
import java.io.Serializable


/**
 * This class is converter class for Room Database to Store Media List.
 */

data class Media(
        @Nullable val uri: String?,
        @Nullable val mimeType: String?,
        @Nullable val units: String?
) : Serializable


data class Article(
        @Nullable val sku: String?,
        @Nullable val media: List<Media>?
) : Serializable {
    var imageUrl: String? = media?.getOrNull(0)?.uri
    var rateStatus: RateStatus? = RateStatus.NONE
    fun liked(): Boolean = rateStatus == RateStatus.LIKE
    fun rated(): Boolean = rateStatus != null && rateStatus != RateStatus.NONE

}
