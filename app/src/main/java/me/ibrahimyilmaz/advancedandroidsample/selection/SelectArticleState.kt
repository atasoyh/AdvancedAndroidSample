package me.ibrahimyilmaz.advancedandroidsample.selection

import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.newsitkotlin.model.Article


data class SelectArticleState(val status: SelectScreenStatus,
                              val messageId: Int = R.string.none,
                              val articles: List<Article> = listOf(),
                              val currentIndex: Int = -1,
                              val likedArticleCount: Int = -1) {
    val formatRatingCount = likedArticleCount.toString().plus("/").plus(currentIndex + 1)
}