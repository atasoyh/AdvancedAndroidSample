package me.ibrahimyilmaz.advancedandroidsample.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.Disposable
import javax.inject.Inject


/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var disposableManager: DisposableManager

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun onViewBound(view: View)

    open fun subscriptions(): List<Disposable> = listOf()

    open fun actionBarVisible() = true

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onDestroyView() {
        disposableManager.clear()
        super.onDestroyView()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layoutRes(), container, false)
        (activity as AppCompatActivity).supportActionBar?.let { actionBar ->
            actionBar.apply {
                if (actionBarVisible()) show()
                else hide()
            }
        }
        disposableManager.addAll(subscriptions())
        onViewBound(view)
        return view
    }
}