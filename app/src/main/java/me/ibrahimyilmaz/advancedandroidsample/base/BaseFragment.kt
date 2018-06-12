package me.ibrahimyilmaz.advancedandroidsample.base

import android.content.Context
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection

/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
open class BaseFragment : Fragment() {
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}