package me.ibrahimyilmaz.advancedandroidsample.selection

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.databinding.FragmentArticleBinding
import me.ibrahimyilmaz.newsitkotlin.model.Article

/**
 * Created by ibrahimyilmaz on 8/24/18 Project AdvancedAndroidSample.
 */
class ArticleFragment : Fragment() {
    val article: Article by lazy { arguments?.getSerializable(KEY_ARTICLE) as Article }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bind = DataBindingUtil.bind<FragmentArticleBinding>(view)
        bind?.let {
            it.article = article
        }
    }

    companion object {
        val KEY_ARTICLE = "article"
        fun newInstance(article: Article) = ArticleFragment().apply {
            arguments = Bundle(1).apply { putSerializable(KEY_ARTICLE, article) }
        }
    }
}