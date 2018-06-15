package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import android.support.v7.widget.RecyclerView
import me.ibrahimyilmaz.advancedandroidsample.databinding.RvNewsItemBinding
import me.ibrahimyilmaz.newsitkotlin.model.Article

/**
 * Created by ibrahimyilmaz on 6/15/18 Project AdvancedAndroidSample.
 */
class TrendingHeadLinesViewHolder constructor(val binding: RvNewsItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        binding.article = article
    }
}