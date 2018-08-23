package me.ibrahimyilmaz.advancedandroidsample.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by ibrahimyilmaz on 8/23/18 Project AdvancedAndroidSample.
 */
interface Navigator {
    fun initWithRoot(fm: FragmentManager, rootFragment: Fragment)
    fun push(fragment: Fragment)
    fun pop()
}