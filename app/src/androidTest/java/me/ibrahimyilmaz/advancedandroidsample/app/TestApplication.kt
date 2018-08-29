package me.ibrahimyilmaz.advancedandroidsample.app

import android.support.test.InstrumentationRegistry
import me.ibrahimyilmaz.advancedandroidsample.di.app.DaggerTestApplicationComponent
import me.ibrahimyilmaz.advancedandroidsample.di.app.SampleApplicationModule
import me.ibrahimyilmaz.advancedandroidsample.di.app.TestApplicationComponent


/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
class TestApplication : Home24TaskApplication() {
    override fun initAppComponent(): TestApplicationComponent {
        return DaggerTestApplicationComponent.builder().sampleApplicationModule(SampleApplicationModule(this))
                .build()
    }

    companion object {
        val component by lazy {
            (InstrumentationRegistry.getTargetContext().applicationContext as TestApplication).applicationComponent as TestApplicationComponent
        }
    }
}

