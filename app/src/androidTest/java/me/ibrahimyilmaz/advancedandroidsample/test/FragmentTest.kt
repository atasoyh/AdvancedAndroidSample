package me.ibrahimyilmaz.advancedandroidsample.test

import android.content.Intent
import me.ibrahimyilmaz.advancedandroidsample.main.MainActivity
import org.junit.Rule


/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
abstract class FragmentTest {

    @Rule
    @JvmField
    var testRule = ControllerTestRule(MainActivity::class.java)

    protected var topHeadLinesService = testRule.testTopHeadLinesService
    protected var topHeadLinesRepository = testRule.repoRepository

    protected fun launch() {
        launch(null)
    }

    protected fun launch(intent: Intent?) {
        testRule.launchActivity(intent)
    }
}