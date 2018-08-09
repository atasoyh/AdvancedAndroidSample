package me.ibrahimyilmaz.advancedandroidsample.test

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner
import me.ibrahimyilmaz.advancedandroidsample.app.TestApplication

/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
class CustomTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestApplication::class.java.name, context)
    }
}