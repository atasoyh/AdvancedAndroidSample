package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import android.arch.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import me.ibrahimyilmaz.advancedandroidsample.base.BaseTest
import me.ibrahimyilmaz.advancedandroidsample.utils.TestHelper
import org.junit.Test


/**
 * Created by ibrahimyilmaz on 8/1/18 Project AdvancedAndroidSample.
 */
class TopHeadLinesViewModelTest : BaseTest() {

    private lateinit var viewModel: TopHeadLinesViewModel
    private lateinit var observer: Observer<TopHeadLinesState>


    override fun setUp() {
        viewModel = TopHeadLinesViewModel()
        observer = mock()
        viewModel.state.observeForever(observer)
    }

    @Test
    fun test_onError() {
        val errorText = "onErrorTest"
        viewModel.onError(Throwable(errorText))
        verify(observer).onChanged(TopHeadLinesState(loading = false, articles = listOf(), errorMessage = errorText))
    }

    @Test
    fun test_onListArticle() {
        viewModel.onListArticle(TestHelper.getTopHeadLines())
        verify(observer).onChanged(TopHeadLinesState(false, errorMessage = "", articles = TestHelper.getTopHeadLines()))
    }

    @Test
    fun test_onLoading() {
        viewModel.onLoading(true)
        verify(observer).onChanged(TopHeadLinesState(loading = true, errorMessage = "", articles = listOf()))
    }

    override fun tearDown() {
        viewModel.state.removeObserver(observer)
    }
}