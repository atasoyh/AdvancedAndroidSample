package me.ibrahimyilmaz.advancedandroidsample.selection

import io.reactivex.Single
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.base.BaseTest
import me.ibrahimyilmaz.advancedandroidsample.base.DisposableManager
import me.ibrahimyilmaz.advancedandroidsample.base.Navigator
import me.ibrahimyilmaz.newsitkotlin.model.Article
import me.ibrahimyilmaz.newsitkotlin.model.ArticlesResponse
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.io.IOException


/**
 * Created by ibrahimyilmaz on 8/27/18 Project AdvancedAndroidSample.
 */
class SelectionPresenterTest : BaseTest() {
    @Mock
    lateinit var requester: ArticlesRequester
    @Mock
    lateinit var viewModel: SelectionViewModel
    @Mock
    lateinit var navigator: Navigator

    @Mock
    lateinit var disposableManager: DisposableManager

    @Mock
    lateinit var mockedState: Consumer<SelectArticleState>


    override fun setUp() {
        MockitoAnnotations.initMocks(this)
        `when`(viewModel.onSelectArticleState()).thenReturn(mockedState)
    }

    @Test
    fun test_error() {
        `when`(requester.listArticles()).thenReturn(Single.error(IOException()))
        SelectionPresenter(viewModel, ArticlesRepository(requester, Schedulers.trampoline()), disposableManager, navigator)

        val inOrder = Mockito.inOrder(mockedState)

        inOrder.verify(mockedState).accept(SelectArticleState(SelectScreenStatus.ON_LOADING))
        inOrder.verify(mockedState).accept(SelectArticleState(SelectScreenStatus.ON_ERROR, messageId = R.string.error_on_network_loading))
    }

    @Test
    fun test_success() {
        val articles = testUtils.loadJson("mock/articlesResponse.json", ArticlesResponse::class.java)?._embedded?.articles!!
        `when`(requester.listArticles()).thenReturn(Single.just<List<Article>>(articles))

        SelectionPresenter(viewModel, ArticlesRepository(requester, Schedulers.trampoline()), disposableManager, navigator)

        val inOrder = Mockito.inOrder(mockedState)

        inOrder.verify(mockedState).accept(SelectArticleState(SelectScreenStatus.ON_LOADING))
        inOrder.verify(mockedState).accept(SelectArticleState(SelectScreenStatus.ON_SUCCESS, articles = articles, currentIndex = 0, likedArticleCount = 0))
    }

    @Test
    fun test_rate() {
        val articles = testUtils.loadJson("mock/articlesResponse.json", ArticlesResponse::class.java)?._embedded?.articles!!
        `when`(requester.listArticles()).thenReturn(Single.just<List<Article>>(articles))

        val presenter = SelectionPresenter(viewModel, ArticlesRepository(requester, Schedulers.trampoline()), disposableManager, navigator)

        val inOrder = Mockito.inOrder(mockedState)
        inOrder.verify(mockedState).accept(SelectArticleState(SelectScreenStatus.ON_LOADING))
        inOrder.verify(mockedState).accept(SelectArticleState(SelectScreenStatus.ON_SUCCESS, articles = articles, currentIndex = 0, likedArticleCount = 0))
        presenter.rateArticle(RateStatus.LIKE)
        articles[0].rateStatus = RateStatus.LIKE
        inOrder.verify(mockedState).accept(SelectArticleState(SelectScreenStatus.ON_SUCCESS, articles = articles, currentIndex = 1, likedArticleCount = 1))
    }

    @Test
    fun test_completed() {
        val articles = testUtils.loadJson("mock/articlesResponse.json", ArticlesResponse::class.java)?._embedded?.articles!!
        `when`(requester.listArticles()).thenReturn(Single.just<List<Article>>(articles))

        val presenter = SelectionPresenter(viewModel, ArticlesRepository(requester, Schedulers.trampoline()), disposableManager, navigator)
        articles.forEach { presenter.rateArticle(RateStatus.LIKE) }

        val inOrder = Mockito.inOrder(mockedState)
        articles.forEachIndexed { index, _ ->
            when {
                index == 0 -> inOrder.verify(mockedState).accept(SelectArticleState(SelectScreenStatus.ON_LOADING))
                index < articles.count() - 1 -> inOrder.verify(mockedState).accept(SelectArticleState(SelectScreenStatus.ON_SUCCESS, articles = articles, currentIndex = index, likedArticleCount = index))
                else -> inOrder.verify(mockedState).accept(SelectArticleState(SelectScreenStatus.ON_FINISHED, articles = articles, currentIndex = -1, likedArticleCount = articles.count(), messageId = R.string.message_all_articles_rated))
            }

        }
    }

    override fun tearDown() {
    }
}