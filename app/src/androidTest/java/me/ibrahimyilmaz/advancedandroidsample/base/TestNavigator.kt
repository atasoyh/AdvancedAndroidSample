package me.ibrahimyilmaz.advancedandroidsample.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ibrahimyilmaz on 8/23/18 Project AdvancedAndroidSample.
 */
@Singleton
class TestNavigator @Inject constructor() : DefaultNavigator() {

    var overridenFragment: Fragment? = null
    override fun initWithRoot(fm: FragmentManager, rootFragment: Fragment) {
        if (overridenFragment != null)
            super.initWithRoot(fm, overridenFragment!!)
        else
            super.initWithRoot(fm, rootFragment)

    }
}