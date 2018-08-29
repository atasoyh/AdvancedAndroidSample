package me.ibrahimyilmaz.advancedandroidsample.selection

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import me.ibrahimyilmaz.newsitkotlin.model.Article

/**
 * Created by ibrahimyilmaz on 8/24/18 Project AdvancedAndroidSample.
 */
class ArticleAdapter constructor(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val articles: MutableList<Article> = mutableListOf()

    fun setItems(items: List<Article>) {
        articles.apply {
            clear()
            addAll(items)
            notifyDataSetChanged()
        }
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun getCount() = articles.size
    override fun getItem(position: Int) = ArticleFragment.newInstance(articles[position])

}