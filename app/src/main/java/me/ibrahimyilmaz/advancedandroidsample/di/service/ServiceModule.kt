package me.ibrahimyilmaz.advancedandroidsample.di.service

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import me.ibrahimyilmaz.advancedandroidsample.service.Home24ArticleService
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@Module
class ServiceModule {

    @Provides
    @Singleton
    fun providesTopHeadLinesService(retrofit: Retrofit) = retrofit.create(Home24ArticleService::class.java)

    @Provides
    @Named("network_scheduler")
    fun provideNetworkScheduler(): Scheduler {
        return Schedulers.io()
    }
}