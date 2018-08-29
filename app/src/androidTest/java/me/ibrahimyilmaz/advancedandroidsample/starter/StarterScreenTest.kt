package me.ibrahimyilmaz.advancedandroidsample.starter

import android.support.test.runner.AndroidJUnit4
import android.support.v4.app.Fragment
import me.ibrahimyilmaz.advancedandroidsample.test.FragmentTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Class for testing Starter Starter Screen
 */
@RunWith(AndroidJUnit4::class)
class StarterScreenTest : FragmentTest() {

    lateinit var robot: StarterScreenRobot
    override val testFragment: Fragment
        get() = StarterScreen()

    @Before
    fun setUp() {
        robot = StarterScreenRobot()
    }

    @Test
    fun test_start_button() {
        launch()
        robot.verifyStartIsVisible()
                .clickStart()
    }
}