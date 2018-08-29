package me.ibrahimyilmaz.advancedandroidsample.starter

import android.databinding.DataBindingUtil
import android.view.View
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.base.BaseFragment
import me.ibrahimyilmaz.advancedandroidsample.databinding.FragmentStarterBinding
import javax.inject.Inject

/***
 * Start Screen
 * <p>
 *     On first launch there should be a full size screen without any action bars containing single button with “Start” caption.
 *     When “Start” button is pressed, “ Selection screen ” should be presented .
 * <p>
 */
class StarterScreen : BaseFragment() {
    @Inject
    lateinit var presenter: StarterPresenter

    override fun layoutRes() = R.layout.fragment_starter
    override fun actionBarVisible() = false
    override fun onViewBound(view: View) {
        var selectionFragmentBinding: FragmentStarterBinding? = DataBindingUtil.bind(view)
        selectionFragmentBinding?.let {
            it.presenter = presenter
        }
    }
}