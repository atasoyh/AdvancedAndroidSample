package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.newsitkotlin.model.Article
import org.threeten.bp.Duration
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter


/**
 * Created by ibrahimyilmaz on 6/14/18 Project AdvancedAndroidSample.
 */
object TopHeadLinesDataBinder {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) =
            Glide.with(imageView.context).apply {
                load(url).apply(RequestOptions().placeholder(R.drawable.img_placeholder).error(R.drawable.img_error))
                        .into(imageView)
            }

    @JvmStatic
    @BindingAdapter("articles")
    fun setArticles(recyclerView: RecyclerView, articles: List<Article>?) {
        val topHeadLinesAdapter: TopHeadLinesAdapter by lazy {
            if (recyclerView.adapter == null) {
                val topHeadLinesAdapter = TopHeadLinesAdapter()
                recyclerView.adapter = topHeadLinesAdapter
                topHeadLinesAdapter
            } else
                recyclerView.adapter as TopHeadLinesAdapter
        }

        articles?.apply {
            topHeadLinesAdapter.setArticles(this)
        }
    }

    @JvmStatic
    @BindingAdapter("publishedAt")
    fun setArticles(textView: TextView, publishedAt: ZonedDateTime?) {
        publishedAt?.apply {
            textView.text = elapsed()
        }
    }

    fun ZonedDateTime.elapsed(): String {
        val between = Duration.between(this, ZonedDateTime.now())
        val format by lazy {
            if (between.toDays() > 0)
                "hh:mm dd MM"
            else
                "hh:mm"
        }
        return DateTimeFormatter.ofPattern(format).format(this)
    }
}