package me.ibrahimyilmaz.advancedandroidsample.review

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.ibrahimyilmaz.advancedandroidsample.databinding.RvArticleListBinding
import me.ibrahimyilmaz.newsitkotlin.model.Article

class ReviewArticlesAdapter(private val articles: ArrayList<Article> = arrayListOf()) : RecyclerView.Adapter<ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val articleItemBinding = RvArticleListBinding.inflate(layoutInflater, parent, false)
        return ArticleViewHolder(articleItemBinding)
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) = holder.bind(articles[position])

    fun setArticles(newArticles: List<Article>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize() = articles.size

            override fun getNewListSize() = newArticles.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    articles.get(oldItemPosition) == newArticles[newItemPosition]


            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    articles.get(oldItemPosition).sku == newArticles[newItemPosition].sku
        })

        articles.apply {
            clear()
            addAll(newArticles)
        }

        diffResult.dispatchUpdatesTo(this)
    }
}