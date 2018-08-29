package me.ibrahimyilmaz.advancedandroidsample.starter

import me.ibrahimyilmaz.advancedandroidsample.base.Navigator
import me.ibrahimyilmaz.advancedandroidsample.di.base.ScreenScope
import javax.inject.Inject

/**
 * Created by ibrahimyilmaz on 8/27/18 Project AdvancedAndroidSample.
 */
@ScreenScope
class StarterPresenter @Inject constructor(private val navigator: Navigator) {

    //When “Start” button is pressed, “ Selection screen ” should be presented .
    fun goToSelectionScreen() {
        navigator.goToSelectionScreen()
    }
}
