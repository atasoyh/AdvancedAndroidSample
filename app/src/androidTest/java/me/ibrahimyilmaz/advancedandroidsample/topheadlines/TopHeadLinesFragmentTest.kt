package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.test.FragmentTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
@RunWith(AndroidJUnit4::class)
class TopHeadLinesFragmentTest : FragmentTest() {

    @Before
    fun setUp() {
        topHeadLinesService.clearErrorFlag()
        topHeadLinesService.clearHoldFlag()
    }


    @Test
    fun load_all_articles_success() {
        launch()
        onView(withId(R.id.pbLoading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tvMessage)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.rvArticles)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun load_all_articles_fail_no_message() {
        topHeadLinesService.errorFlags = 1
        launch()
        onView(withId(R.id.pbLoading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.tvMessage)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withId(R.id.rvArticles)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
    }

    @Test
    fun load_all_articles_waiting() {
        topHeadLinesService.holdFlags = 1
        launch()
        onView(withId(R.id.pbLoading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withId(R.id.tvMessage)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withId(R.id.rvArticles)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
    }
}