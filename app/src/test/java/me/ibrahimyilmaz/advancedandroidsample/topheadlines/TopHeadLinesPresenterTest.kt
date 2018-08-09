package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import android.arch.lifecycle.Observer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Single
import me.ibrahimyilmaz.advancedandroidsample.base.BaseTest
import me.ibrahimyilmaz.advancedandroidsample.base.DisposableManager
import me.ibrahimyilmaz.advancedandroidsample.utils.TestUtils
import me.ibrahimyilmaz.newsitkotlin.model.TopHeadLineResponse
import org.junit.Test


/**
 * Created by ibrahimyilmaz on 8/1/18 Project AdvancedAndroidSample.
 */
class TopHeadLinesPresenterTest : BaseTest() {

    private lateinit var disposableManager: DisposableManager

    private lateinit var repository: TopHeadLinesRepository

    private lateinit var viewModel: TopHeadLinesViewModel
    private lateinit var presenter: TopHeadLinesPresenter

    private lateinit var observer: Observer<TopHeadLinesState>


    override fun setUp() {
        disposableManager = mock<DisposableManager>()
        observer = mock()
        repository = mock {
            on { listArticles() } doReturn Single.just(TestUtils().loadJson("mock/top-headlines.json", TopHeadLineResponse::class.java)?.articles!!)
        }
        viewModel = TopHeadLinesViewModel()
        presenter = TopHeadLinesPresenter(viewModel = viewModel, disposableManager = disposableManager, repository = repository)
        viewModel.state.observeForever(observer)
    }

    override fun tearDown() {
        viewModel.state.removeObserver(observer)
    }

    @Test
    fun test_listArticles() {
        presenter.listArticles()
        verify(observer).onChanged(TopHeadLinesState(loading = true, articles = listOf(), errorMessage = ""))
        verify(observer).onChanged(TopHeadLinesState(loading = false, articles = TestUtils().loadJson("mock/top-headlines.json", TopHeadLineResponse::class.java)?.articles!!, errorMessage = ""))

    }
}