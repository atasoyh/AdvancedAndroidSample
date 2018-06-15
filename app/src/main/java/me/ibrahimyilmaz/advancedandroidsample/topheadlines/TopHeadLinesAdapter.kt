package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.ibrahimyilmaz.advancedandroidsample.databinding.RvNewsItemBinding
import me.ibrahimyilmaz.newsitkotlin.model.Article

/**
 * Created by ibrahimyilmaz on 6/15/18 Project AdvancedAndroidSample.
 */
class TopHeadLinesAdapter(private val articles: MutableList<Article> = mutableListOf()) : RecyclerView.Adapter<TrendingHeadLinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingHeadLinesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val newsItemBinding = RvNewsItemBinding.inflate(layoutInflater, parent, false)
        return TrendingHeadLinesViewHolder(newsItemBinding)
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: TrendingHeadLinesViewHolder, position: Int) = holder.bind(articles[position])

    fun setArticles(newArticles: List<Article>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize() = articles.size

            override fun getNewListSize() = newArticles.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    articles.get(oldItemPosition) == newArticles[newItemPosition]


            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    articles.get(oldItemPosition).url == newArticles[newItemPosition].url
        })

        articles.apply {
            clear()
            addAll(newArticles)
        }

        diffResult.dispatchUpdatesTo(this)
    }
}