package me.ibrahimyilmaz.advancedandroidsample.review

import android.support.v7.widget.RecyclerView
import me.ibrahimyilmaz.advancedandroidsample.databinding.RvArticleListBinding
import me.ibrahimyilmaz.newsitkotlin.model.Article

class ArticleViewHolder constructor(val binding: RvArticleListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(article: Article) {
        binding.article = article
    }
}