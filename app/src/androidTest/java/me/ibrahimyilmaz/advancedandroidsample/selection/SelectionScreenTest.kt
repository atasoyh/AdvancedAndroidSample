package me.ibrahimyilmaz.advancedandroidsample.selection

import android.support.test.runner.AndroidJUnit4
import android.support.v4.app.Fragment
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.test.FragmentTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Class for testing of Selection Screen
 */
@RunWith(AndroidJUnit4::class)
class SelectionScreenTest : FragmentTest() {
    lateinit var robot: SelectionScreenRobot
    override val testFragment: Fragment = SelectionScreen()
    @Before
    fun setUp() {
        testRule.clearState()

    }

    @Test
    fun test_loading_articles() {

        topHeadLinesService.holdFlags = 1
        launch()
        robot = SelectionScreenRobot(testRule.activity)
        robot.checkWaitingIsVisible()
                .checkMessageIsGone()
                .checkRatingStatusGone()
                .checkViewPagerGone()
                .checkActionButtonsAreGone()
                .checkReviewGone()
    }

    @Test
    fun test_success_articles() {
        launch()
        robot = SelectionScreenRobot(testRule.activity)
        robot.checkWaitingIsGone()
                .checkMessageIsGone()
                .checkRatingStatusVisible()
                .checkViewPagerVisible()
                .checkActionButtonsAreVisible()
                .checkReviewVisible()
                .checkReviewDisabled()
    }


    @Test
    fun test_failed_loading_articles() {
        topHeadLinesService.errorFlags = 1

        launch()
        robot = SelectionScreenRobot(testRule.activity)
        robot.checkWaitingIsGone()
                .checkMessageIsVisible()
                .checkRatingStatusGone()
                .checkViewPagerGone()
                .checkActionButtonsAreGone()
                .checkReviewGone()
                .checkErrorText(R.string.error_on_network_loading)
    }


    @Test
    fun test_like_article() {
        launch()
        robot = SelectionScreenRobot(testRule.activity)
        robot.checkRatingStatusText("0/1")
                .likeArticle()
                .checkRatingStatusText("1/2")

    }

    @Test
    fun test_dislike_article() {
        launch()
        robot = SelectionScreenRobot(testRule.activity)
        robot.checkRatingStatusText("0/1")
                .likeArticle()
                .checkRatingStatusText("1/2")
                .dislikeArticle()
                .checkRatingStatusText("1/3")

    }

    @Test
    fun test_rate_all() {
        launch()
        robot = SelectionScreenRobot(testRule.activity)
        robot.likeArticle(10)
                .checkRatingStatusGone()
                .checkMessageText(R.string.message_all_articles_rated)
                .checkReviewEnabled()

    }
}