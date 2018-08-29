package me.ibrahimyilmaz.advancedandroidsample.test

import android.app.Activity
import android.support.test.rule.ActivityTestRule
import me.ibrahimyilmaz.advancedandroidsample.app.TestApplication
import me.ibrahimyilmaz.advancedandroidsample.base.TestNavigator
import me.ibrahimyilmaz.advancedandroidsample.selection.ArticlesRepository
import me.ibrahimyilmaz.advancedandroidsample.service.TestHome24ArticleService


/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
class ControllerTestRule<T : Activity>(activityClass: Class<T>) : ActivityTestRule<T>(activityClass, true, false) {

    val testTopHeadLinesService: TestHome24ArticleService by lazy {
        TestApplication.component.topHeadLinesService()

    }
    val repoRepository: ArticlesRepository by lazy {
        TestApplication.component.topHeadLinesRepository()
    }

    val testNavigationModule: TestNavigator by lazy {
        TestApplication.component.testNavigator()
    }

    fun clearState() {
        testTopHeadLinesService.clearErrorFlag()
        testTopHeadLinesService.clearHoldFlag()
        repoRepository.clearCache()
    }
}