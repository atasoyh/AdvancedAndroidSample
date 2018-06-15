package me.ibrahimyilmaz.advancedandroidsample.app

import android.app.Activity
import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import me.ibrahimyilmaz.advancedandroidsample.di.app.DaggerSampleApplicationComponent
import me.ibrahimyilmaz.advancedandroidsample.di.app.SampleApplicationModule
import javax.inject.Inject

/**
 * Created by ibrahimyilmaz on 6/12/18 Project AdvancedAndroidSample.
 */
class SampleApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    private val applicationComponent by lazy {
        DaggerSampleApplicationComponent.builder()
                .sampleApplicationModule(SampleApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent.inject(this)
        AndroidThreeTen.init(this)
    }
}