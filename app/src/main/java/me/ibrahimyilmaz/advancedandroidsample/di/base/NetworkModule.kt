package me.ibrahimyilmaz.advancedandroidsample.di.base

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


/**
 * Created by ibrahimyilmaz on 6/13/18 Project AdvancedAndroidSample.
 */
@Module
class NetworkModule {

    @Provides
    fun providesMoshi() = Moshi.Builder().build()


    @Provides
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
        val httpUrl = chain.request().url().newBuilder().addQueryParameter("apiKey", "8702d1ca1acc423183af02400b3064c0")
                .build()
        val request = chain.request().newBuilder().url(httpUrl)
                .build()
        chain.proceed(request)
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl("https://api-mobile.home24.com/api/v1/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

}