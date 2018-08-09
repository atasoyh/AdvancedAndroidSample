package me.ibrahimyilmaz.advancedandroidsample.topheadlines

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Named


/**
 * Created by ibrahimyilmaz on 8/2/18 Project AdvancedAndroidSample.
 */
@Module(includes = [TestTopHeadLinesServiceModule.StaticModule::class])
abstract class TestTopHeadLinesServiceModule {

    @Binds
    abstract fun provideTopHeadLinesService(service: TestTopHeadLinesService): TopHeadLinesService

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