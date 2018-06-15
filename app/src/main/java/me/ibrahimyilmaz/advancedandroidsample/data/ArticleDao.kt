package me.ibrahimyilmaz.advancedandroidsample.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Maybe
import me.ibrahimyilmaz.newsitkotlin.model.Article


/**
 * Created by ibrahimyilmaz on 6/15/18 Project AdvancedAndroidSample.
 */
@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun listArticles(): Maybe<List<Article>>

    @Insert
    fun insert(article: Article)

    @Insert
    fun insert(article: List<Article>)
}