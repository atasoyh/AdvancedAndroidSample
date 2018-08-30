package me.ibrahimyilmaz.advancedandroidsample.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


/**
 * Created by ibrahimyilmaz on 6/12/18 Project AdvancedAndroidSample.
 */
abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    abstract val layoutResID: Int

    abstract val rootFragment: Fragment

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutResID)
        if (fragmentContainer == null)
            throw IllegalArgumentException("Activity should contain fragmentContainer!")
        navigator.initWithRoot(supportFragmentManager, rootFragment)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {
        val result = navigator.pop()
        if (!result) {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}