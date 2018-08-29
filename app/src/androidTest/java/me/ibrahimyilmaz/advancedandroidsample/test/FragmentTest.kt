package me.ibrahimyilmaz.advancedandroidsample.test

import android.content.Intent
import android.support.v4.app.Fragment
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
    protected var testNavigationModule = testRule.testNavigationModule

    abstract val testFragment: Fragment

    protected fun launch() {
        testNavigationModule.overridenFragment = testFragment
        launch(null)
    }

    protected fun launch(intent: Intent?) {
        testRule.launchActivity(intent)
    }

}