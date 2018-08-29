package me.ibrahimyilmaz.advancedandroidsample.selection

import android.content.Context
import android.support.test.espresso.matcher.ViewMatchers
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.base.BaseTestRobot

/**
 * Created by ibrahimyilmaz on 8/29/18 Project AdvancedAndroidSample.
 */
class SelectionScreenRobot(val context: Context) : BaseTestRobot() {

    fun checkWaitingIsVisible() = apply {
        checkVisibility(R.id.pb_waiting, ViewMatchers.Visibility.VISIBLE)
    }

    fun checkWaitingIsGone() = apply {
        checkVisibility(R.id.pb_waiting, ViewMatchers.Visibility.GONE)
    }

    fun checkMessageIsVisible() = apply {
        checkVisibility(R.id.tv_message, ViewMatchers.Visibility.VISIBLE)
    }

    fun checkMessageIsGone() = apply {
        checkVisibility(R.id.tv_message, ViewMatchers.Visibility.GONE)
    }

    fun checkRatingStatusVisible() = apply {
        checkVisibility(R.id.tv_rating_status, ViewMatchers.Visibility.VISIBLE)
    }

    fun checkRatingStatusGone() = apply {
        checkVisibility(R.id.tv_rating_status, ViewMatchers.Visibility.GONE)
    }

    fun checkViewPagerVisible() = apply {
        checkVisibility(R.id.obligatory, ViewMatchers.Visibility.VISIBLE)
    }

    fun checkViewPagerGone() = apply {
        checkVisibility(R.id.obligatory, ViewMatchers.Visibility.GONE)
    }

    fun checkActionButtonsAreVisible() = apply {
        checkVisibility(R.id.ll_buttons, ViewMatchers.Visibility.VISIBLE)
    }

    fun checkActionButtonsAreGone() = apply {
        checkVisibility(R.id.ll_buttons, ViewMatchers.Visibility.GONE)
    }


    fun checkReviewVisible() = apply {
        checkVisibility(R.id.btn_review, ViewMatchers.Visibility.VISIBLE)
    }

    fun checkReviewGone() = apply {
        checkVisibility(R.id.btn_review, ViewMatchers.Visibility.GONE)
    }

    fun checkReviewEnabled() = apply {
        checkEnabled(R.id.btn_review, true)
    }

    fun checkReviewDisabled() = apply {
        checkEnabled(R.id.btn_review, false)
    }

    fun checkErrorText(resourceId: Int) = apply {
        matchText(R.id.tv_message, context.getString(resourceId))

    }

    fun likeArticle(count: Int = 1) = apply {
        for (i in count downTo 1)
            clickButton(R.id.btn_like)
    }

    fun checkRatingStatusText(s: String) = apply {
        matchText(R.id.tv_rating_status, s)
    }

    fun dislikeArticle(count: Int = 1) = apply {

        for (i in count downTo 1)
            clickButton(R.id.btn_dislike)
    }

    fun checkMessageText(resourceId: Int) = apply {
        matchText(R.id.tv_message, context.getString(resourceId))
    }


}