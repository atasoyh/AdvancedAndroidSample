package me.ibrahimyilmaz.advancedandroidsample.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by ibrahimyilmaz on 8/23/18 Project AdvancedAndroidSample.
 */
interface Navigator {
    fun initWithRoot(fm: FragmentManager, rootFragment: Fragment)
    fun push(fragment: Fragment)
    fun pop(): Boolean
    /***
     * This method will be called When “Start” button is pressed.
     * There is no argument of this method because “ Selection screen ” should be presented.
     */
    fun goToSelectionScreen()
}