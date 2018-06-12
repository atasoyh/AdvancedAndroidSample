package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.base.BaseFragment


class TopHeadLinesFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_head_lines, container, false)
    }


}
