package me.ibrahimyilmaz.advancedandroidsample.main

import android.support.v4.app.Fragment
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.base.BaseActivity
import me.ibrahimyilmaz.advancedandroidsample.starter.StarterScreen

class MainActivity : BaseActivity() {
    override val rootFragment: Fragment = StarterScreen()
    override val layoutResID = R.layout.activity_main
}
