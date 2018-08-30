package me.ibrahimyilmaz.advancedandroidsample.selection

import android.databinding.DataBindingUtil
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_selection.view.*
import me.ibrahimyilmaz.advancedandroidsample.R
import me.ibrahimyilmaz.advancedandroidsample.base.BaseFragment
import me.ibrahimyilmaz.advancedandroidsample.databinding.FragmentSelectionBinding
import javax.inject.Inject


class SelectionScreen : BaseFragment() {

    @Inject
    lateinit var viewModel: SelectionViewModel
    @Inject
    lateinit var presenter: SelectionPresenter

    var selectionFragmentBinding: FragmentSelectionBinding? = null
    override fun layoutRes() = R.layout.fragment_selection

    override fun onViewBound(view: View) {
        selectionFragmentBinding = DataBindingUtil.bind(view)
        view.obligatory.offscreenPageLimit = 3 // caching for performance
    }

    override fun subscriptions() = listOf(
            viewModel.selectArticleState()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { starterState ->
                        starterState?.let {
                            selectionFragmentBinding?.selectArticleState = it
                            selectionFragmentBinding?.presenter = presenter
                        }
                    }

    )

    companion object {
        fun newInstance() = SelectionScreen()
    }
}
