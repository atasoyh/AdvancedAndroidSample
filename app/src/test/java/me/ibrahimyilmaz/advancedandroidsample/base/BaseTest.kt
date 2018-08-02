package me.ibrahimyilmaz.advancedandroidsample.base

import android.arch.core.executor.testing.InstantTaskExecutorRule
import me.ibrahimyilmaz.advancedandroidsample.utils.RxSchedulerTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule

/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
abstract class BaseTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    var instantExecutorRule = RxSchedulerTestRule()


    @Before
    fun before() {
        setUp()
    }

    @After
    fun after() {
        tearDown()
    }

    abstract fun setUp()
    abstract fun tearDown()
}
