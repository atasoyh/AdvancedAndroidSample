package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.fragment_top_head_lines.view.*
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.base.BaseFragment
import me.ibrahimyilmaz.advancedandroidsample.databinding.FragmentTopHeadLinesBinding
import java.util.*
import javax.inject.Inject


class TopHeadLinesFragment : BaseFragment() {

    @Inject
    lateinit var presenter: TopHeadLinesPresenter

    @Inject
    lateinit var viewModel: TopHeadLinesViewModel


    override fun layoutRes() = R.layout.fragment_top_head_lines

    override fun onViewBound(view: View) {
        val topHeadLinesBinding = DataBindingUtil.bind<FragmentTopHeadLinesBinding>(view)
        view.rvArticles.apply {
            val linearLayoutManager = LinearLayoutManager(rvArticles.context)
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(rvArticles.context, linearLayoutManager.orientation))
        }

        viewModel.state.observe(this, Observer { topHeadLinesBinding?.state = it })
        presenter.listArticles()
    }

    companion object {
        fun newInstance(): Fragment = TopHeadLinesFragment().apply {
            arguments = Bundle().apply {
                putString("instance_id", UUID.randomUUID().toString())
            }
        }


    }
}
