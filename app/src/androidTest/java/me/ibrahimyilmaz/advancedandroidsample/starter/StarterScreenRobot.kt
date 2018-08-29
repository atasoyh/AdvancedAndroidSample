package me.ibrahimyilmaz.advancedandroidsample.starter

import android.support.test.espresso.matcher.ViewMatchers
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.base.BaseTestRobot

/**
 * Created by ibrahimyilmaz on 8/29/18 Project AdvancedAndroidSample.
 */
class StarterScreenRobot : BaseTestRobot() {
    fun clickStart() = apply {
        clickButton(R.id.btn_start)
    }

    fun verifyStartIsVisible() = apply {
        checkVisibility(R.id.btn_start, ViewMatchers.Visibility.VISIBLE)
    }

}