package me.ibrahimyilmaz.advancedandroidsample.starter

import com.nhaarman.mockitokotlin2.verify
import me.ibrahimyilmaz.advancedandroidsample.base.BaseTest
import me.ibrahimyilmaz.advancedandroidsample.base.Navigator
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 *  Class for testing  StarterPresenter
 */
class StarterPresenterTest : BaseTest() {
    @Mock
    lateinit var navigator: Navigator
    lateinit var presenter: StarterPresenter
    override fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = StarterPresenter(navigator)
    }

    @Test
    fun test_go_selection_screen() {
        presenter.goToSelectionScreen()
        verify(navigator).goToSelectionScreen()
    }

    override fun tearDown() {
    }
}