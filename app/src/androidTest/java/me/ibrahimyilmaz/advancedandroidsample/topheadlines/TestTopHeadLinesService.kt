package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import android.os.Handler
import android.os.Looper
import io.reactivex.Single
import me.ibrahimyilmaz.newsitkotlin.model.TopHeadLineResponse
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
@Singleton
class TestTopHeadLinesService @Inject constructor(private val testUtils: TestUtils) : TopHeadLinesService {

    val FLAG_GET_TEAMS = 1

    var errorFlags: Int = 0
    var holdFlags: Int = 0

    override fun listTopHeadLines(country: String): Single<TopHeadLineResponse> =
            if (errorFlags and FLAG_GET_TEAMS == 0) {
                val loadJson = testUtils.loadJson("mock/top-headlines.json", TopHeadLineResponse::class.java)!!

                if (holdFlags and FLAG_GET_TEAMS == FLAG_GET_TEAMS) {
                    holdingSingle(loadJson, FLAG_GET_TEAMS)
                } else {
                    Single.just(loadJson)
                }
            } else {
                Single.error(IOException())
            }


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

