package me.ibrahimyilmaz.advancedandroidsample.service

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Named


/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
@Module(includes = [Home24ServiceModule.StaticModule::class])
abstract class Home24ServiceModule {

    @Binds
    abstract fun provideTopHeadLinesService(service: TestHome24ArticleService): Home24ArticleService

    @Module
    object StaticModule {
        @JvmStatic
        @Provides
        @Named("network_scheduler")
        fun provideNetworkScheduler(): Scheduler {
            return Schedulers.trampoline()
        }
    }


}