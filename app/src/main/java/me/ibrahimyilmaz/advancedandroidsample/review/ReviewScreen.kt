package me.ibrahimyilmaz.advancedandroidsample.review

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.fragment_review.view.*
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.base.BaseFragment
import me.ibrahimyilmaz.newsitkotlin.model.Article

class ReviewScreen : BaseFragment() {


    fun setRecyclerViewLayoutManager(mRecyclerView: RecyclerView, layoutManagerType: LayoutManagerType) {
        var scrollPosition = 0

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.layoutManager != null) {
            scrollPosition = (mRecyclerView.layoutManager as LinearLayoutManager)
                    .findFirstCompletelyVisibleItemPosition()
        }


        val layoutManager = when (layoutManagerType) {
            LayoutManagerType.GRID_LAYOUT_MANAGER ->
                GridLayoutManager(mRecyclerView.context, 2)

            LayoutManagerType.LINEAR_LAYOUT_MANAGER ->
                LinearLayoutManager(mRecyclerView.context)

        }

        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.scrollToPosition(scrollPosition)
    }

    override fun layoutRes() = R.layout.fragment_review
    override fun onViewBound(view: View) {
        arguments?.let {
            view.rv_items.adapter = ReviewArticlesAdapter(it.getSerializable(KEY_ARTICLES) as ArrayList<Article>)
            view.rv_items.layoutManager = LinearLayoutManager(context)
        }


        view.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                setRecyclerViewLayoutManager(view.rv_items, if (tab?.position == 0) LayoutManagerType.LINEAR_LAYOUT_MANAGER else LayoutManagerType.GRID_LAYOUT_MANAGER)
            }

        })
    }


    companion object {
        val KEY_ARTICLES: String = "articles"
        fun newInstance(articles: ArrayList<Article>) = ReviewScreen().apply { arguments = Bundle().apply { putSerializable(KEY_ARTICLES, articles) } }
    }
}