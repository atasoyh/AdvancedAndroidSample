package me.ibrahimyilmaz.advancedandroidsample.di.topheadlines

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import me.ibrahimyilmaz.advancedandroidsample.topheadlines.TopHeadLinesService
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@Module
class TopHeadLinesServiceModule {

    @Provides
    @Singleton
    fun providesTopHeadLinesService(retrofit: Retrofit) = retrofit.create(TopHeadLinesService::class.java)

    @Provides
    @Named("network_scheduler")
    fun provideNetworkScheduler(): Scheduler {
        return Schedulers.io()
    }
}