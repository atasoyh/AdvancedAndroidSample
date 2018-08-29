package me.ibrahimyilmaz.advancedandroidsample.base

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.*

open class BaseTestRobot {

    fun checkVisibility(resId: Int, visibility: ViewMatchers.Visibility): ViewInteraction =
            onView(withId(resId)).check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility)))

    fun checkEnabled(resId: Int, enabled: Boolean): ViewInteraction =
            onView(withId(resId)).check(ViewAssertions.matches(if (enabled) ViewMatchers.isEnabled() else not(ViewMatchers.isEnabled())))

    fun fillEditText(resId: Int, text: String): ViewInteraction =
            onView(withId(resId)).perform(ViewActions.replaceText(text), ViewActions.closeSoftKeyboard())

    fun clickButton(resId: Int): ViewInteraction = onView((withId(resId))).perform(ViewActions.click())

    fun textView(resId: Int): ViewInteraction = onView(withId(resId))

    fun matchText(viewInteraction: ViewInteraction, text: String): ViewInteraction = viewInteraction
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))

    fun matchText(resId: Int, text: String): ViewInteraction = matchText(textView(resId), text)

    fun clickListItem(listRes: Int, position: Int) {
        onData(anything())
                .inAdapterView(allOf(withId(listRes)))
                .atPosition(position).perform(ViewActions.click())
    }


}