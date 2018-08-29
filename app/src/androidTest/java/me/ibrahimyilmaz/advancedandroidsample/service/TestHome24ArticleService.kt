package me.ibrahimyilmaz.advancedandroidsample.service

import android.os.Handler
import android.os.Looper
import io.reactivex.Single
import me.ibrahimyilmaz.advancedandroidsample.utils.TestUtils
import me.ibrahimyilmaz.newsitkotlin.model.ArticlesResponse
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
@Singleton
class TestHome24ArticleService @Inject constructor(private val testUtils: TestUtils) : Home24ArticleService {
    override fun listArticles(options: Map<String, String>): Single<ArticlesResponse> {
        if (errorFlags and FLAG_GET_TEAMS == 0) {
            val loadJson = testUtils.loadJson("mock/articlesResponse.json", ArticlesResponse::class.java)!!

            if (holdFlags and FLAG_GET_TEAMS == FLAG_GET_TEAMS) {
                return holdingSingle(loadJson, FLAG_GET_TEAMS)
            } else {
                return Single.just(loadJson)
            }
        } else {
            return Single.error(IOException())
        }
    }

    val FLAG_GET_TEAMS = 1

    var errorFlags: Int = 0
    var holdFlags: Int = 0


    private fun <T> holdingSingle(result: T, flag: Int): Single<T> {
        return Single.create { emitter ->
            val handler = Handler(Looper.getMainLooper())
            val holdRunnable = object : Runnable {
                override fun run() {
                    if (holdFlags and flag == flag) {
                        handler.postDelayed(this, 50)
                    } else {
                        emitter.onSuccess(result)
                    }
                }
            }
            holdRunnable.run()
        }


    }

    fun clearErrorFlag() {
        errorFlags = 0
    }

    fun clearHoldFlag() {
        holdFlags = 0
    }
}

