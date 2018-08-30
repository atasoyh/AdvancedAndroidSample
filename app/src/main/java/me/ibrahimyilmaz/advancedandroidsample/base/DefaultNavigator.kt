package me.ibrahimyilmaz.advancedandroidsample.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.review.ReviewScreen
import me.ibrahimyilmaz.advancedandroidsample.selection.SelectionScreen
import me.ibrahimyilmaz.newsitkotlin.model.Article
import javax.inject.Singleton

/**
 * Created by ibrahimyilmaz on 8/23/18 Project AdvancedAndroidSample.
 */
@Singleton
open class DefaultNavigator : Navigator {


    private lateinit var fragmentManager: FragmentManager

    fun FragmentManager.push(fragment: Fragment) {
        beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack("")
                .commit()
        executePendingTransactions()
    }

    fun FragmentManager.setRoot(fragment: Fragment) {
        beginTransaction()
                .replace(R.id.fragmentContainer, fragment).commit()
        executePendingTransactions()
    }

    fun FragmentManager.pop(): Boolean {
        return popBackStackImmediate()
    }


    override fun initWithRoot(fm: FragmentManager, rootFragment: Fragment) {
        fragmentManager = fm
        if (fragmentManager.fragments.isEmpty()) {
            fragmentManager.setRoot(fragment = rootFragment)
        }
    }

    override fun push(fragment: Fragment) {
        fragmentManager.push(fragment = fragment)
    }

    override fun pop() =
            fragmentManager.pop()

    override fun goToSelectionScreen() {
        push(SelectionScreen.newInstance())
    }

    override fun goToSelectionScreen(articles: ArrayList<Article>) {
        push(ReviewScreen.newInstance(articles))
    }

}