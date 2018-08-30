package me.ibrahimyilmaz.advancedandroidsample.selection

import android.databinding.BindingAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.review.LayoutManagerType
import me.ibrahimyilmaz.newsitkotlin.model.Article


/**
 * Created by ibrahimyilmaz on 6/14/18 Project AdvancedAndroidSample.
 */
object DataBinder {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) =
            Glide.with(imageView.context).apply {
                load(url).apply(RequestOptions().placeholder(R.drawable.img_placeholder).error(R.drawable.img_error))
                        .into(imageView)
            }

    @JvmStatic
    @BindingAdapter("articles")
    fun setArticles(viewPager: ViewPager, articles: List<Article>?) {
        articles?.let {
            val articleAdapter: ArticleAdapter by lazy {
                if (viewPager.adapter == null) {
                    val adapter = ArticleAdapter((viewPager.context!! as AppCompatActivity).supportFragmentManager)
                    viewPager.adapter = adapter
                }
                viewPager.adapter as ArticleAdapter
            }

            if (it.isNotEmpty()) {
                articleAdapter.setItems(it)
                articleAdapter.notifyDataSetChanged()
            }
        }
    }

    @JvmStatic
    @BindingAdapter("currentPage")
    fun setCurrentPage(viewPager: ViewPager, currentPage: Int = 0) {
        viewPager.adapter?.let {
            viewPager.currentItem = currentPage
        }
    }

}
