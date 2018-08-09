package me.ibrahimyilmaz.advancedandroidsample.test

import android.app.Activity
import android.support.test.rule.ActivityTestRule
import me.ibrahimyilmaz.advancedandroidsample.app.TestApplication
import me.ibrahimyilmaz.advancedandroidsample.topheadlines.TestTopHeadLinesService
import me.ibrahimyilmaz.advancedandroidsample.topheadlines.TopHeadLinesRepository


/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
class ControllerTestRule<T : Activity>(activityClass: Class<T>) : ActivityTestRule<T>(activityClass, true, false) {

    val testTopHeadLinesService: TestTopHeadLinesService by lazy {
        TestApplication.component.topHeadLinesService()

    }
    val repoRepository: TopHeadLinesRepository by lazy {
        TestApplication.component.topHeadLinesRepository()
    }


    fun clearState() {
        testTopHeadLinesService.clearErrorFlag()
        testTopHeadLinesService.clearHoldFlag()
        //        topHeadLinesRepository.clearCache();
    }
}